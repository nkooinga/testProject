package com.stc.roster.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;

public class ReusableMethods {

    public static rawToJsonArrayRes(Response res) {

    ArrayList<String > responseArray = new res.asString();
        JsonPath response = new JsonPath(responseArray);
        return response;

    }

    public static rawToJsonString(Response res) {

        String responseString = new res.asString();
        JsonPath response = new JsonPath(responseString);
        return response;
    }

}
