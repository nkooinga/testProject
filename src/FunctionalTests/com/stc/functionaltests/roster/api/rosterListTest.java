package com.stc.functionaltests.roster.api;

import com.stc.roster.api.rosterList;
import io.restassured.http.ContentType;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;

/**
 * Created by nkooinga on 6/5/2017.
 */
public class rosterListTest extends rosterList {
//Test for IWEBMODERN-5
    @BeforeSuite
    public void accessRosterPage() {
        given()
                .param(/*ROSTERURI*/)
                .param(/*schoolNurseSelection*/)
        .when()
                .get("/com/stc/integrationtests/roster/api")
        .then()
                .assertThat()
                .statusCode(200)
                .log()
                .headers();

    }
//Tests for IWEBMODERN-7
    @Test()
    public void getSchoolRoster() {
        given()
                .param(/*schoolSpecificRoster*/)
                .param(/*schoolNurse*/)
        .when()
                .get("/com/stc/integrationtests/roster/api/list")
        .then()
                .body("rosterList.list", hasItems("schoolName","schoolAddress", "firstName","lastName","grade","patientAddress","patientDOB","patientGuardian","patientForecast"))


    }
    //Nurse should not be able to select school
    @Test
    public void nurseSchoolSearch() {
        given()
                .param(/*SchoolNurseCreds*/)
                .param(/*SchoolSelection*/)
        .when()
                .post()
        .then()
                .log()
                .body();
    }
    //School Distrue Client Test
    @Test
    public void districtUserSchoolsView() {
        given()
                .param(/*districtUserParams*/)
        .when()
                .get("/list")
        .then()
                .log()
                .body("schools.list", hasItems("schools"));
    }
    //Nurse switching grades of patients
    @Test
    public void nurseGradeChange() {
        given()
                .contentType(ContentType.JSON)
                .param(/*Nurse Param*/)
                .param(/*Grade Change Param*/)
        .when()
                .body(/*studentVarCall*/)
                .post()
        .then()
                .statusCode(201)
                .log()
                .body(contains(/*studentVarCall*/));


    }

}