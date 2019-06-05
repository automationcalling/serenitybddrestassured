package com.automationcalling.testrunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/getallsearchstates/Search_States.feature",
        glue = {"com.automationcalling.stepdefinitions"})
public class GetAllStatesRunner {
}
