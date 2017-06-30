//package com.stc.roster.po;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
//
///**
// * Created by nkooinga on 5/30/2017.
// */
//public class RosterObjects {
//    private final WebDriver driver;
//
//    WebDriver driver;
//    public RosterObjects (WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
//    }
//
//
//    @FindBy(linkText = "vaccination")
//    private WebElement vaccSummaryPage;
//
//
//    @FindBy(linkText = "form")
//    private WebElement cisForm;
//
//
//    @FindBy(id = "grade")
//    private WebElement gradeLevel;
//
//
//    @FindBy(id = "forecastStatus")
//    private WebElement forecastStatus;
//
//
//    }
//}
