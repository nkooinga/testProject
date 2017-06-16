package com.stc.roster.properties;

import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.principal;


/**
 * Created by nkooinga on 6/16/2017.
 */
public class RosterAPIProperties {
// Will need to update this as well before go live
    public static void init() {
        RestAssured.basePath = "URL HERE";
        RestAssured.baseURI = "/roster";
        RestAssuredMockMvc.authentication = principal("username", "password");


    }
}