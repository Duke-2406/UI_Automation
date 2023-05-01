package Indigo.StepDefinitions;

import Indigo.Components.BaseTest;
import Indigo.PageObjects.ConfirmationPage;
import Indigo.PageObjects.FlightCatalogue;
import Indigo.PageObjects.LandingPage;
import Indigo.PageObjects.PassengerDetails;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.jv.Lan;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class stepDefinitionImp extends BaseTest {

    public WebDriver driver;
    @Before
    public void launchApp() throws IOException {
        driver = initializeDriver();
    }

    @Given("I landed on Home Page")
    public void I_landed_on_home_Page() throws IOException{
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.searchFlight();
    }

    @Given("I landed on Home Page and search for round trip")
    public void i_lander_on_home_page_and_search_for_round_trip(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.searchFlightRoundTrip();
    }

    @Then("I select My Flight")
    public void i_select_my_flight(){
        FlightCatalogue flightCatalogue = new FlightCatalogue(driver);
        flightCatalogue.selectFlight();
        flightCatalogue.popupForPhoneNumberAndEmailID();
    }

    @Then("I select My Flight for Round Trip")
    public void i_select_my_flight_for_round_trip(){
        FlightCatalogue flightCatalogue = new FlightCatalogue(driver);
        flightCatalogue.seleceBothFlight();
        flightCatalogue.popupForPhoneNumberAndEmailID();
    }

    @Then("I fill passenger details")
    public void i_fill_passenger_details(){
        PassengerDetails passengerDetails = new PassengerDetails(driver);
        passengerDetails.fillPassengerDetails();
    }

    @Then("I confirm my flight")
    public void i_confirm_my_flight(){
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        confirmationPage.confirmPage();
    }

    @After
    public void AfterScenario()
    {
        System.out.println("browser close");
        driver.quit();
    }

//    @AfterStep
//    public void AddScreenshot(Scenario scenario) throws IOException
//    {
//        System.out.println("take screenshot");
//        if(scenario.isFailed())
//        {
//            //screenshot
//
//            File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
//            scenario.attach(fileContent, "image/png", "image");
//
//        }
//
//    }
}
