package com.stc.roster.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by nkooinga on 5/30/2017.
 */
public class RosterObjects {

    WebDriver driver;
    public RosterObjects (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(linkText = "demo")
    WebElement demoPage;

    public WebElement demoPage() {
            return this.demoPage;
    }

    @FindBy(linkText = "vaccination")
    WebElement vaccSummaryPage;

    public WebElement vaccSummaryPage() {
            return this.vaccSummaryPage;

    }

    @FindBy(linkText = "form")
    WebElement cisForm;

    public WebElement cisForm() {
        return this.cisForm;
    }

    @FindBy(id = "grade")
    WebElement gradeLevel;

    public WebElement gradeLevel() {
        return this.gradeLevel;
    }


}
