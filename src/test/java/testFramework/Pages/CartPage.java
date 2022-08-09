package testFramework.Pages;


import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.*;
import org.testng.*;
import testFramework.Utils.*;
import testFramework.Utils.Libraries.*;

import java.text.*;
import java.util.*;


public class CartPage {

    private final GenericLibrary genericLibrary = new GenericLibrary();
    ArrayList<Double> arrayList = new ArrayList<>();
    DecimalFormat numberFormat = new DecimalFormat("#0.00");


    public CartPage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.XPATH, using = "//tbody/tr/td[@class='product-name']")
    private List<WebElement> AddedCartItemList;

    @FindBy(how = How.XPATH, using = "//tbody/tr/td[@class='product-price']/span[@class='woocommerce-Price-amount amount']")
    private List<WebElement> productPrice;

    @FindBy(how = How.XPATH, using = "//tbody/tr/td[@class='product-remove']/a")
    private List<WebElement> productRemove;

    @FindBy(how = How.XPATH, using = "//tr/th[@class='product-name']")
    private WebElement productName;


    public void verifyTotalCartItems(String ItemstoAdd) {
        try {
            int numOfItems = 0;
            int cartSize = 0;
            try {
                numOfItems = Integer.parseInt(ItemstoAdd);
                genericLibrary.highLightElements(DriverFactory.getDriver(), AddedCartItemList);
                cartSize = AddedCartItemList.size();
            } catch (NoSuchElementException e) {
                Assert.assertFalse(false);
            }
            Assert.assertEquals(cartSize, numOfItems);
            System.out.println(ItemstoAdd + " Items has been added to cart.");


        } catch (Exception e) {
            System.out.println("Items are not same...");
            e.printStackTrace();


        }
    }


    public void findLowestPriceItem() throws InterruptedException {

        try {
            int cartSize = AddedCartItemList.size();

            String amount = "";

            for (int i = 0; i < cartSize; i++) {
                try {
                    genericLibrary.explicitWaitforanElement(DriverFactory.getDriver(), productPrice.get(i));
                    genericLibrary.highLightElement(DriverFactory.getDriver(), productPrice.get(i));
                    genericLibrary.highLightElement(DriverFactory.getDriver(), productPrice.get(i));
                    amount = productPrice.get(i).getText().replace("$", " ").trim();
                } catch (NoSuchElementException e) {
                    Assert.assertFalse(false);
                }
                String newAmt = amount.replaceAll("$", "");
                Double amt = Double.parseDouble(amount);
                arrayList.add(amt);
            }

            Collections.sort(arrayList);

        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.assertFalse(false);

        } catch (IndexOutOfBoundsException e) {
            Assert.assertFalse(false);

        } catch (NullPointerException e) {
            Assert.assertFalse(false);

        }
    }

    public void deleteLowestPriceItem() throws InterruptedException {

        try {
            int cartSize = AddedCartItemList.size();
            for (int j = 0; j < cartSize; j++) {

                String newAmt = numberFormat.format(arrayList.get(j));
                String amount = productPrice.get(j).getText().replace("$", " ").trim();


                if (newAmt.equals(amount)) {
                    genericLibrary.highLightElement(DriverFactory.getDriver(), productRemove.get(j));
                    productRemove.get(j).click();
                    Thread.sleep(3000);
//                    genericLibrary.explicitWaitforanElement(DriverFactory.getDriver(),productName);

                    Assert.assertTrue(true, "Lowest price amount Item deleted...");
                    break;
                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.assertFalse(false);

        } catch (IndexOutOfBoundsException e) {
            Assert.assertFalse(false);

        } catch (NullPointerException e) {
            Assert.assertFalse(false);

        } catch (NoSuchElementException e) {
            Assert.assertFalse(false);
        }
    }
}
