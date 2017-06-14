package com.stc.functionaltests.roster.api;

import com.stc.roster.api.RosterDownloadUpload;
import com.stc.roster.api.rosterList;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.testng.annotations.*;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasToString;

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
                .get("/roster")
        .then()
                .log()
                .body("rosterList.list");
    }

//Tests for IWEBMODERN-6, IWEBMODERN-7
    @Test()
    public void getSchoolRoster() {
        given()
                .param(/*schoolSpecificRoster*/)
                .param(/*schoolNurse*/)
        .when()
                .get("/roster")
        .then()
                .body("rosterList.count", equalTo(/*Number of kids in roster*/))
                .body("rosterList.list", hasItems("schoolName","schoolAddress", "schoolPhone","schoolDistrict","firstName","lastName","grade","patientAddress","patientDOB","patientGuardian","patientForecast"))


    }

    @Test
    public void searchSchoolRoster() {
        given()
                .param(/*studentParameters*/)
                .param(/*schoolBurse*/)
        .when()
                .get("/roster/search")
        .then()
                .body("rosterList.list", hasItems("firstName", "alstName", "grade", "PatientAddress", " patientDOB", "patientGuardian", "patientForecast"))
                .statusCode(200);
    }

    @Test
    public void linkStudentDemo() {
        given()
                .param(/*studentParameters*/)
        .when()
                .get("/studentDemographics")
        .then()
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    public void linkStudentVacc() {
        given()
                .param(/*studentParameters*/)
        .when()
                .get("/studentVaccinations")
        .then()
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    public void linkStudentCIS() {
        given()
                .param(/*studentParameters*/)
        .when()
                .get("/studentForm")
        .then()
                .log()
                .body()
                .statusCode(200);
    }

    @Test
    public void updateStudentGrade() {
        given()
                .contentType(ContentType.JSON)
        .when()
                .body(.param(/*studentParameters*/))
                .patch()
        .then()
                .log()
                .body(hasItem(/*NewGradeLevel*/));
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