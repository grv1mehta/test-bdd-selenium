package framework.steps;


import framework.utils.DriverFactory;
import io.cucumber.java.en.*;
import framework.pages.CartPage;
import framework.pages.HomePage;

public class VerifyItemsInCartSteps {

    private final HomePage homePage = new HomePage(DriverFactory.getDriver());
    private final CartPage cartPage = new CartPage(DriverFactory.getDriver());


    @Given("I add {string} random Items to my cart")
    public void i_add_random_items_to_my_cart(String items) throws InterruptedException {
        homePage.addItemsToCart(items);
    }
    @When("I view my cart {string}")
    public void i_view_my_cart(String items) throws InterruptedException {
        homePage.clickViewCartBtn(items);

    }

    @Then("I find the total {string} items listed in my cart")
    public void i_find_the_total_items_listed_in_my_cart(String totalItems) {

        cartPage.verifyTotalCartItems(totalItems);

    }

    @When("I search for lowest price item")
    public void i_search_for_lowest_price_item() throws InterruptedException {
        cartPage.findLowestPriceItem();

    }

    @And("I am able to remove the lowest price item from my cart")
    public void iam_able_to_remove_the_lowest_price_item_from_my_cart() throws InterruptedException {

        cartPage.deleteLowestPriceItem();

    }

    @Then("Iam able to verify {string} items in my cart")
    public void iam_able_to_verify_items_in_my_cart(String totalItems) {

        cartPage.verifyTotalCartItems(totalItems);

    }

}
