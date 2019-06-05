package com.automationcalling.stepdefinitions;

import com.automationcalling.features.States_Territories_of_a_Country;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class SearchStateSteps {
    @Steps
    States_Territories_of_a_Country states_territories_of_a_country;

    @Given("^I supply country code \"([^\"]*)\" to get all states$")
    public void i_supply_country_code_to_get_all_states(String countryName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        states_territories_of_a_country.searchallStatesOfGivenCountry(countryName);
    }

    @Then("^I get (\\d+) records found in the given country code$")
    public void i_get_records_found_in_the_given_country_code(int recordCount) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        states_territories_of_a_country.validateRecordCount(36);
    }
}
