package com.stc.roster.api;

import io.restassured.http.ContentType;

/**
 * Created by nkooi on 5/27/2017.
 */
public class example {

    public static example example(example placeholder){
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("http://localhost:3001/placeholder");
    }
}
