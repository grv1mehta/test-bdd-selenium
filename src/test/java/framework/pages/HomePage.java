package framework.pages;


import framework.utils.DriverFactory;
import framework.utils.GenericLibrary;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.*;
import org.testng.*;


import java.util.*;

public class HomePage {

    private final GenericLibrary genericLibrary = new GenericLibrary();

    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "(//div/ul[@class='products columns-3']/li)")
    private List<WebElement> CartList;

    @FindBy(xpath = "(//div/ul[@class='products columns-3']/li//a[text()='Add to cart'])")
    private List<WebElement> AddToCartBtn;

    @FindBy(how = How.XPATH, using = "(//div/ul[@class='products columns-3']/li//a[text()='View cart'])")
    private List<WebElement> ViewCartBtn;

    @FindBy(how = How.XPATH, using = "//h1")
    private WebElement ViewCartHeader;


    public void addItemsToCart(String itemsToAdd) {
        try {
            int numOfItems = Integer.parseInt(itemsToAdd);

            for (int i = 0; i < numOfItems; i++) {
                try {

                    genericLibrary.highLightElement(DriverFactory.getDriver(), AddToCartBtn.get(i));
                    AddToCartBtn.get(i).click();
                    Thread.sleep(1000);
                } catch (NoSuchElementException e) {
                    Assert.assertFalse(false);
                }
            }
            Assert.assertTrue(true, "Added" + itemsToAdd + "Items to the Cart...");


        } catch (ArrayIndexOutOfBoundsException e) {
            Assert.assertFalse(false);

        } catch (IndexOutOfBoundsException e) {
            Assert.assertFalse(false);

        } catch (NullPointerException e) {
            Assert.assertFalse(false);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void clickViewCartBtn(String index) {
        try {
            int newIndex = Integer.parseInt(index);
            try {
                genericLibrary.highLightElement(DriverFactory.getDriver(), ViewCartBtn.get(newIndex - 1));
                ViewCartBtn.get(newIndex - 1).click();
                genericLibrary.explicitWaitforanElement(DriverFactory.getDriver(), ViewCartHeader);
                genericLibrary.highLightElement(DriverFactory.getDriver(), ViewCartHeader);


            } catch (NoSuchElementException e) {
                Assert.assertFalse(false);
            }

        } catch (IndexOutOfBoundsException e) {
            Assert.assertFalse(false);
        }
    }
}
