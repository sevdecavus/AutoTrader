package com.autotrader.stepDefinitions;

import com.autotrader.pages.AdvancedSearchPage;
import com.autotrader.pages.AutoTraderPage;
import com.autotrader.utilities.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AutoTraderSteps  {
    AutoTraderPage autoTraderPage = new AutoTraderPage();
    AdvancedSearchPage advancedSearchPage =new AdvancedSearchPage();

    @Given("User is in landing page")
    public void user_is_in_landing_page() {
        System.out.println("Landing page");
        String actualTitle = MyDriver.get().getTitle();
        String expectedTitle= "Used and New Car Sales, Review - Autotrader";

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("Verify that {string} is present")
    public void verify_that_is_present(String expected) {
        autoTraderPage.verifications(expected);

    }

    @Then("Verify that search Button is present")
    public void verify_that_search_Button_is_present() {
        autoTraderPage.searchButton();
    }

    @Then("Verify that {string} and {string}")
    public void verify_that_and(String make, String model) {

        autoTraderPage.verifyMakeAndModel(make,model);
    }

    @Given("User click Advance Search link on the home page")
    public void user_click_Advance_Search_link_on_the_home_page() {
        MyDriver.get().manage().deleteAllCookies();
        advancedSearchPage.advanceSearchClick();
    }

    @Then("User enter {string} in the zip code text box")
    public void user_enter_in_the_zip_code_text_box(String zipcode) {

        advancedSearchPage.zipCode(zipcode);
    }

    @Then("User select {string} check box under {string}")
    public void user_select_check_box_under(String string, String string2) {
        advancedSearchPage.verifyclickCertifiedAndCovertible(string);
    }

    @Then("user update Year {string} to {string}")
    public void user_update_Year_to(String from, String to) {
        advancedSearchPage.startDateAndEndDate(from, to);
    }

    @Then("user select {string} car from Make,Model and Trim section")
    public void user_select_car_from_Make_Model_and_Trim_section(String vehicle) {
        advancedSearchPage.selectVehicle(vehicle);
    }

    @Then("User clicks Search button")
    public void user_clicks_Search_button() {

        advancedSearchPage.clickSearchButton();
    }

    @Then("User verifies that he is in result page")
    public void user_verifies_that_he_is_in_result_page() {

        advancedSearchPage.verifyResultPage();
    }

    @Then("User verifies that he sees only {string} cars in listing")
    public void user_verifies_that_he_sees_only_cars_in_listing(String car) {

        advancedSearchPage.verifyBMWListing(car);
    }

    @Then("Display in console, the number of cars listed in result page")
    public void display_in_console_the_number_of_cars_listed_in_result_page() {
    }

    @Given("choose make as {string}")
    public void choose_make_as(String string) {
    }
}
