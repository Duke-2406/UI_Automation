package Deepak.stepDefinitions;

import Deepak.Components.BaseTest;
import Deepak.PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class StepDefinitionImp extends BaseTest {

    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;
    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password (String username, String password){
        productCatalogue = landingPage.loginApplication(username,password);
    }

    @When("^I add product (.+) to cart$")
    public void i_add_product_to_cart(String productName){
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
    }

    @And("^Checkout (.+) and submit the order$")
    public void checkout_submit_order(String productName){
        CartPage cartPage = productCatalogue.gotoCartPage();

        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        confirmationPage = checkoutPage.submitOrder();
    }

    @Then("{string} message is displayed on confirmation page")
    public void message_displayed_confirmation_page(String successMessage){
        String confirmMessage = confirmationPage.getVerifyConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(successMessage));
        driver.close();
    }

    @Then("{string} message is displayed")
    public void error_message_displayed(String errorMessage){
        Assert.assertEquals(errorMessage, landingPage.getErrorMessage());
        driver.close();
    }
}
