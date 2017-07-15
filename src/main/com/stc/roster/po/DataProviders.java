package com.stc.roster.po;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {{"TSPEARS", "password1"}};
    }
}
