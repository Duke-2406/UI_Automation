package Indigo.PageObjects;

import Indigo.AbstractComponents.abstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmationPage extends abstractComponent {
    WebDriver driver;
    public ConfirmationPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Skip')]")
    WebElement skipBtn;

    @FindBy(xpath = "//span[@class='RecordLocator']")
    WebElement confirmationNumber;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement checkBox;

    public void confirmPage(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", skipBtn);
        js.executeScript("arguments[0].click();", skipBtn);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        js.executeScript("arguments[0].scrollIntoView();", checkBox);
//        js.executeScript("arguments[0].click();", checkBox);
//        boolean isElementEnabled = false;
//        if(confirmationNumber.getText().isEmpty()){
//            isElementEnabled = true;
//        }
//        Assert.assertTrue(isElementEnabled);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Book flights Online for Domestic and International - IndiGo");
    }
}
