package com.stc.functionaltests.roster.api;

import com.stc.roster.api.RosterDownloadUpload;
import com.stc.roster.api.rosterList;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.testng.annotations.*;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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

    @Test
    public void accessRosterWithoutSchoolSelection() {
        given()
                .param(/*ROSTERURI*/)
        .when()
                .get()
        .then()
                .log()
                .body();
    }

    @Test
    public void accessRosterasSDCwithoutSchoolSeleciton() {
        given()
                .param(/*ROSTERURI*/)
                .param(/*SDCPARAMS*/)
        .when()
                .get()
        .then()
                .log()
                .body("/list");
    }

    @Test
    public void accessRosterasSDCwithSchoolSelection() {
        given()
                .param(/*ROSTERURI*/)
                .param(/*SDCPARAMS*/)
        .when()
                .get()
        .then()
                .log()
                .body("/list");
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
    //School District Client Test
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

//    Tests for IWEBMODERN-16
    @BeforeMethod
    public void rosterDownloadCheck() {
        File rosterDownload = new File(System.getProperty("/*Download Directory Location*/") + File.separator + "/*File name*/");

        int expectedSize = (int) rosterDownload.length();

        System.out.println("Expected file size: " + expectedSize + " bytes")
    }
    @Test
    public void rosterTemplateDownload() {

        byte[] actualValue = given()
            .when()
                .get(/*DOWNLOADURL*/)
            .then()
                .extract()
                .asByteArray();

        assertThat(expectedSize, equalTo(actualValue.length));

    }

    @Test
    public void rosterUpload() {
        given()
                .multiPart("Roster Upload File")
        .when()
                .post("/fileUploadPath")
        .then()
                .body("fileUploadResult", equalTo("OK"))
                .log()
                .status()
                .statuscode(302);

    }
    @BeforeMethod
    public void rosterUnamtchedDownloadCheck() {
        File unmatchedCheck = new File(System.getProperty("/*Download Directory Location*/")  + File.separator + "/*File name*/");

        int expectedSize
    }

    @Test
    public void unmatchedDownload() {
        given()
                .param(/*Unmatched Students Parameters*/)
        .when()
                .get("/unmatchedDownload")
        .then()
    }


}