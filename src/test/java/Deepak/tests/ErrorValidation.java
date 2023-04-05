package Deepak.tests;

import Deepak.Components.BaseTest;
import Deepak.Components.Retry;
import Deepak.PageObjects.CartPage;
import Deepak.PageObjects.ProductCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends BaseTest {
    @Test (retryAnalyzer = Retry.class)
    public void errorValidation() {
        ProductCatalogue productCatalogue = landingPage.loginApplication("deepaksihare891@gmail.com", "sdfjjhsd");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }

    @Test
    public void productErrorValidation() throws IOException {
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("deepaksihare891@gmail.com","Deepak@2406");

        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.gotoCartPage();

        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}
