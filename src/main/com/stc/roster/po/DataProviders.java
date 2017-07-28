package com.stc.roster.po;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviders {

    @DataProvider(name = "Authentication")
    public static Object[][] credentials(Method method) {
        String testCase = method.getName();
        if ("invalidLoginTest".equals(testCase)) {
            return new Object[][]{
                    {"ABC123", "QWERTY!987"}
                    ,{"Test", "Test"}};
        } else
            return new Object[][] {
                    {"nick_sn", "nick_sn"}};
    }

    @DataProvider(name = "Roster Search")
    public static Object[][] rosterSearch(Method method) {
        String testCase = method.getName();
        if ("validRosterSearch".equals(testCase)) {
            return new Object[][]{
                    {"Test"}
                    , {"Student1"}
                    , {"Student2"}
                    , {"Student3"}
                    , {"Student4"}};
        } else
            return new Object[][] {
                    {"-em"}
                    ,{"@1902"}
                    ,{"SELECT user;"}
                    ,{"SELECT current_database()"}};

    }


    @DataProvider(name = "Student Information")
    public static Object[][] studentInformation(Method method) {
        String testCase = method.getName();
        if ("validInfoFields".equals(testCase)) {
            return new Object[][]{
                    {"Mary", "Testmore", "Sue"}
                    ,{"Larry", "Bestmore", "Matt"}
                    ,{"John", "Johnson", "Jared"}
                    ,{"Susan", "Lazy", "Jane"}};
        } else if ("invalidInfoFields".equals(testCase)) {
            return new Object[][] {
                    {"@39dcd", "w.)_32thn", "Werner$"}
                    ,{"DROP USER test", "SELECT USERS;", "."}};
        } else
            return new Object[][] {
                    {"Herbert", "Hoover", "A."}
                    ,{"George", "Washington", "C."}};
    }

    @DataProvider(name = "Student Birthdate")
    public static Object[][] studentBirthdate(Method method) {
        String testCase = method.getName();
        if ("validBirthdate".equals(testCase)) {
            return new Object[][] {
                    {"01/01/2010"}
                    ,{"12/31/1999"}
                    ,{"02/29/2000"}};
        } else if ("invalidBirthdate".equals(testCase)) {
            return new Object[][] {
                    {"00/32/2020"}
                    ,{"01013000"}
                    ,{"01/-2/2010"}
                    ,{"10/ab/2010"}
                    ,{"12/!S/2OlO"}
                    ,{"1001@@@@"}};
        } else
            return new Object[][] {
                    {"07/01/2010"}};
    }

    @DataProvider(name = "Guardian Information")
    public static Object[][] guarddianInformation(Method method) {
        String testCase = method.getName();
        if ("validGuardianInfo".equals(testCase)) {
            return new Object[][]{
                    {"Ned Stark", "4807458641", "9328", "W. Winterfell St.", "85028"}
                    , {"Lancell Lanister", "6022601023", "2392", "S. Red Keep Dr.", "39284"}
                    , {"Olena Tyrell", "2194651016", "993", "E. Highgarden Blvd.", "98253"}};
        } else if ("invalidGuardianInfo".equals(testCase)) {
            return new Object[][]{
                    {"Ary@ $tark", "!20380asd@", "-123", "N. N0n@m3 St.", "73945"}
                    , {"G3ndry R0wb0@t", "(null)", "392", "Rowing Dr.", "-1202"}};
        } else
            return new Object[][]{
                    {"New Guardian", "18008885555", "1234", "Main St.", "90210"}};
    }




}




