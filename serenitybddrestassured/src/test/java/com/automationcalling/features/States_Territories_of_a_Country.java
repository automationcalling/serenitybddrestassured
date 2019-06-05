package com.automationcalling.features;

import com.automationcalling.utils.restapi.RestAssuredCore;
import com.automationcalling.utils.restapi.RestResponse;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.automationcalling.utils.restapi.RestAssuredCore.initializeLogger;

public class States_Territories_of_a_Country {
    private static RestAssuredCore restAssuredCore;
    private static RestResponse restResponse;

    static {
        try {
            initializeLogger();
            restAssuredCore = new RestAssuredCore();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public States_Territories_of_a_Country(){
        restAssuredCore = new RestAssuredCore();
    }*/

    @Step("Searches all states of a country")
    public void searchAllStatesofaCountry() {
        try {
            restAssuredCore.initRestAssuredCore("http://services.groupkt.com/", "state/");
            restAssuredCore.setURLEncodingStatus(false).invokeRestCall("GET", "get/IND/UP").getAPIResponseAsPrettyPrint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Search and get all States of a given country :{0}")
    public void searchallStatesOfGivenCountry(String countryName) {
        restAssuredCore.initRestAssuredCore("http://services.groupkt.com/", "state/");
        restResponse = restAssuredCore.setURLEncodingStatus(false).invokeRestCall("GET", "get/"+countryName+"/all");
        Assert.assertEquals(200, restResponse.getStatusCode());
        restResponse.getAPIResponseAsPrettyPrint();
    }

    @Step("Return Record count: {0}")
    public void validateRecordCount(int countValue)
    {
        String actualvalue=null;
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(restResponse.getJsonPathReturnValue("string","RestResponse.messages"));
        if (m.find()) {
            actualvalue=m.group();
        }
        Assert.assertEquals(countValue,Integer.parseInt(actualvalue));
    }

    public void resetRest() {
        restAssuredCore.resetRestConfig("All");
    }
}
