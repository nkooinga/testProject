package com.stc.roster.api;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class Payload {

    @DataProvider(name = "rosterPaginationValues")
    public static Object[][] rosterPaginationValues(Method method) {
        String testCase = method.getName();
        if ("happyRosterPageValues".equals(testCase)) {
            return new Object[][]{{"1", "10"}, {"1", "100"}, {"2", "10"}, {"2", "100"}, {"10", "10"}, {"10", "100"}};
        } else if ("negRosterPageValues".equals(testCase)) {
            return new Object[][]{{"-1", "1"}, {"0", "9"}, {"1000", "1000"}};
        } else {
            return new Object[][]{{"A","A"}, {"DROP USER test;","SELECT current_setting('data_directory');"}, {"@$"," "}};
        }
    }
}