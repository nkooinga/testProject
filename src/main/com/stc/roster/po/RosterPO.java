package com.stc.roster.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by nkooinga on 5/30/2017.
 */
public class RosterPO {

    WebDriver driver;
    public RosterPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "student-searchEnter name, ID, DOB, etc")
    private WebElement studentSearch;

    @FindBy(className = "glyphicon glyphicon-pencil gvBOhn")
    private WebElement studentDemo;

    @FindBy(className = "Add New Student")
    private WebElement addNewStudentBtn;

    @FindBy(className = "Update Roster")
    private WebElement updateRosterBtn;

    @FindBy(linkText = "vaccination")
    private WebElement vaccSummaryPage;


    @FindBy(linkText = "form")
    private WebElement cisForm;


    @FindBy(id = "grade")
    private WebElement gradeLevel;


    @FindBy(id = "forecastStatus")
    private WebElement forecastStatus;



}
