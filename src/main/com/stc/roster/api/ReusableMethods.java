//package com.stc.roster.api;
//
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//
//import java.util.ArrayList;
//
//public class ReusableMethods {
//
//    public static JsonPath rawToJsonArray(Response response) {
//
//    ArrayList<String > responseArray = new response.asString();
//        JsonPath js = new JsonPath(responseArray);
//        return js;
//
//    }
//
//    public static JsonPath rawToJsonString(Response response) {
//
//        String responseString = new response.asString();
//        JsonPath js = new JsonPath(responseString);
//        return js;
//    }
//
//
//}
