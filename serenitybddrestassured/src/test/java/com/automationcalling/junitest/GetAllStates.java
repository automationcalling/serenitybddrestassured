package com.automationcalling.junitest;

import com.automationcalling.features.States_Territories_of_a_Country;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by Muthu on 06/06/2019.
 */

@RunWith(SerenityRunner.class)
public class GetAllStates {
    @Steps
    private static States_Territories_of_a_Country steps;

    @Test
    @Title("Get all States of a Country")
    public void getAllStatesofACountry(){
        steps.searchAllStatesofaCountry();
    }

    @AfterClass
    public static void tearDown()
    {
        steps.resetRest();
    }
}
