package com.stc.functionaltests.roster.ui;

import com.stc.roster.po.RosterObjects;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by nkooinga on 6/12/2017.
 */
public class RosterUI extends RosterObjects() {

//  Tests for IWEBMODERN-6
    @BeforeSuite
    public void rosterPageAccess(){
//  Create variable for driver instantiation, driver properties, and URL to get
        driver.get("URL HERE");
        driver.manage().window().maximize();
        Assert.assertEquals("URL",driver.getTitle());

        }

//  Get forecast status
    @Test
    public void getForecastStatus(){
        RosterObjects ro = new RosterObjects(driver);
//  Need to create endpoint variable once it is available.
        if(ro.forecastStatus()!= null){
        System.out.println("Status is present: "  + ro.forecastStatus);
        } else {
            System.out.println("Status is NOT present")
        }


        }


}
