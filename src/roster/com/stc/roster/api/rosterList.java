package com.stc.roster.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created by nkooi on 5/27/2017.
 */
public class rosterList {

    public static void init() {
//      UPDATE URI
        RestAssured.baseURI = "http://schoolnurse.com";
        RestAssured.basePath = "/roster";

    }

    private String schoolName;

    private String schoolAddress;

    private String firstName;

    private String lastName;

    private String patientAddress;

    private String patientDOB;

    private String patientGuardian;

    private String patientForecast;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(String patientDOB) {
        this.patientDOB = patientDOB;
    }

    public String getPatientGuardian() {
        return patientGuardian;
    }

    public void setPatientGuardian(String patientGuardian) {
        this.patientGuardian = patientGuardian;
    }

    public String getPatientForecast() {
        return patientForecast;
    }

    public void setPatientForecast(String patientForecast) {
        this.patientForecast = patientForecast;
    }



}
