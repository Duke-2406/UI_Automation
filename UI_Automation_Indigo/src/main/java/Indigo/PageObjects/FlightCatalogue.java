package Indigo.PageObjects;

import Indigo.AbstractComponents.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class FlightCatalogue extends abstractComponent {
    WebDriver driver;
    public FlightCatalogue(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath=".//div[@class='fare-accordion']")
    List<WebElement> numbersOfFlight;

    @FindBy(xpath = "(//h3[contains(text(),'Saver')])[1]/parent::div/parent::div/parent::div//span[contains(text(),'Book')]")
    WebElement bookButton;

    @FindBy(xpath = "//span[contains(text(),'Skip & continue with saver fare')]")
    WebElement skipButton;

    @FindBy(xpath = "//span[contains(text(),'Enter Country Code')]/parent::div//input[@placeholder='Enter Mobile No.']")
    WebElement mobileNumberInput;

    @FindBy(xpath = "//h2[contains(text(),'Contact Details')]/parent::div//input[@placeholder='Email ID']")
    WebElement emailIDInput;

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement nextBtn;

    public void selectFlight(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(numbersOfFlight.size()==0){
            Assert.assertTrue(false);

        }
        else {
            numbersOfFlight.get(0).click();
        }
        waitForWebElementToAppear(bookButton);
        bookButton.click();

        waitForWebElementToClickable(skipButton);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", skipButton);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForWebElementToClickable(mobileNumberInput);
        mobileNumberInput.sendKeys("6264632149");
        emailIDInput.sendKeys("deepaksihare891@gmail.com");
        waitForWebElementToClickable(nextBtn);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", nextBtn);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
