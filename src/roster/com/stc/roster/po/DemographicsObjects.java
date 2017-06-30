package com.stc.roster.po;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DemographicsObjects {
    private final WebDriver driver;

    WebDriver driver;
    public DemographicsObjects (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(linkText = "demo")
    private WebElement demoPage;


    @FindBy(id = "firstName")
    private WebElement patientFirstName;


    @FindBy(id = "lastName")
    private WebElement patientLastName;


    @FindBy(id = "phone")
    private WebElement patientPhone;


    @FindBy(id = "patientAddress")
    private WebElement patientAddress;


    @FindBy(id = "grade")
    private WebElement patientGrade;


    @FindBy(id = "school")
    private WebElement patientSchool;


    @FindBy(id = "district")
    private WebElement patientDistrict;


    @FindBy(id = "guardian1Name")
    private WebElement guardian1Name;


    @FindBy(id = "guardian1Phone")
    private WebElement guardian1Phone;


    @FindBy(id = "guardian2Name")
    private WebElement guardian2Name;


    @FindBy(id = "guardian2Phone")
    private WebElement guardian2Phone;


    @FindBy(id = "entryDate")
    private WebElement entryDate;


    @FindBy(id = "editButton")
    private WebElement editButton;


    @FindBy(id = "save")
    private WebElement saveButton;


    @FindBy(id = "cisForm")
    private WebElement cisForm;


    @FindBy(id =  "breadCrumbs")
    private WebElement breadCrumbs;





}
