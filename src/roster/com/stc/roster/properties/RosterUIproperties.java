package com.stc.roster.properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by nkooinga on 6/13/2017.
 */
public class RosterUIproperties {

//  Chromedriver properties
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "{$BASE_PATH}");

        WebDriver driver = new ChromeDriver();
        driver.get("URLHERE");

    }

    public void remoteChromeDriverSetup() {
        DesiredCapabilities capabilities = new DesiredCapabilities.ChromeDriver();
        capabilities.setBrowserName("chromedriver");
// ***CHANGE THIS LINE FOR PROD***
        capabilities.setPlatform("TBD");

    }


    public void remoteFirefoxDriverSetup() {
        DesiredCapabilities capabilities = new DesiredCapabilities.FirefoxDriver();
        capabilities.setBrowserName("firefox");
// ***CHANGE THIS LINE FOR PROD***
        capabilities.setPlatform("TBD");

    }


    public void remoteIEDriverSetup() {
        DesiredCapabilities capabilities = new DesiredCapabilities.InternetExplorerDriver();
        capabilities.setBrowserName("internet explorer");
// ***CHANGE THIS LINE FOR PROD***
        capabilities.setPlatform("TBD");

    }
}
