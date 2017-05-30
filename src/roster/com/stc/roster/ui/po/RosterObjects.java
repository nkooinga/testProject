package com.stc.roster.ui.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nkooinga on 5/30/2017.
 */
public class RosterObjects

    WebDriver driver;
    public RosterObjects (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(//placeholder)
    WebElement //placeholder

    public WebElement (//placeholder) {
            return //placeholder;
            }
}
