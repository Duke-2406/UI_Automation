package Indigo.StepDefinitions;

import Indigo.Components.BaseTest;
import Indigo.PageObjects.ConfirmationPage;
import Indigo.PageObjects.FlightCatalogue;
import Indigo.PageObjects.LandingPage;
import Indigo.PageObjects.PassengerDetails;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class stepDefinitionImp extends BaseTest {

    @Given("I landed on Home Page")
    public void I_landed_on_home_Page() throws IOException{
        driver = initializeDriver();
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.searchFlight();
    }

    @Then("I select My Flight")
    public void i_select_my_flight(){
        FlightCatalogue flightCatalogue = new FlightCatalogue(driver);
        flightCatalogue.selectFlight();
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
}
