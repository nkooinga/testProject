package com.stc.roster.po;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DemographicsPO {

    WebDriver driver;

    public DemographicsPO (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    @FindBy(className = "glyphicon-pencil")
    private WebElement studentDemo;

    public WebElement getStudentDemo() {
        return studentDemo;
    }

    @FindBy(id = "gradeGrade")
    private WebElement patientGrade;

    public WebElement getPatientGrade() {
        return patientGrade;
    }

    @FindBy(id = "birthDateBirth Date")
    private WebElement patientDOB;

    public WebElement getPatientDOB() {
        return patientDOB;
    }

    @FindBy(id = "firstNameFirst Name")
    private WebElement patientFirstName;

    public WebElement getPatientFirstName() {
        return patientFirstName;
    }

    @FindBy(id = "lastNameLast Name")
    private WebElement patientLastName;

    public WebElement getPatientLastName() {
        return patientLastName;
    }

    @FindBy(id = "middleNameM.I.")
    private WebElement patientMiddleName;

    public WebElement getPatientMiddleName() {
        return patientMiddleName;
    }

    @FindBy(id = "addressNumberStreet Num.")
    private WebElement patientStreetNum;

    public WebElement getPatientStreetNum() {
        return patientStreetNum;
    }

    @FindBy(id = "addressNameStreet Name")
    private WebElement patientStreetName;

    public WebElement getPatientStreetName() {
        return patientStreetName;
    }

    @FindBy(id = "zipCodeZIP Code")
    private WebElement patientZipCode;

    public WebElement getPatientZipCode() {
        return patientZipCode;
    }

    @FindBy(id = "phoneNumberPhone")
    private WebElement patientPhone;

    public WebElement getPatientPhone() {
        return patientPhone;
    }

    @FindBy(id = "emailEmail")
    private WebElement patientEmail;

    public WebElement getPatientEmail() {
        return patientEmail;
    }

    @FindBy(id = "guardianFull Name")
    private WebElement guardian1Name;

    public WebElement getGuardian1Name() {
        return guardian1Name;
    }

    @FindBy(id = "guardianPhonePhone")
    private WebElement guardian1Phone;

    public WebElement getGuardian1Phone() {
        return guardian1Phone;
    }

    @FindBy(id = "guardianAddressNumberStreet Num.")
    private WebElement guardianStreetNum;

    public WebElement getGuardianStreetNum() {
        return guardianStreetNum;
    }

    @FindBy(id = "guardianAddressNameStreet Name")
    private WebElement guardianStreetName;

    public WebElement getGuardianStreetName() {
        return guardianStreetName;
    }

    @FindBy(id = "guardianZipCodeZIP Code")
    private WebElement guardianZipCode;

    public WebElement getGuardianZipCode() {
        return guardianZipCode;
    }

    @FindBy(id = "motherMaidenNameMother's Maiden Name")
    private WebElement motherMaiden;

    public WebElement getMotherMaiden() {
        return motherMaiden;
    }

    @FindBy(xpath = "html/body/div[2]/div/div[2]/div/div/div/div/div[2]/div[6]/div/div/button[1]")
    private WebElement editBtn;

    public WebElement getEditBtn() {
        return editBtn;
    }

    @FindBy(xpath = "html/body/div[2]/div/div[2]/div/div/div/div/div[2]/div[6]/div/div/button[1]")
    private WebElement saveBtn;

    public WebElement getSaveBtn() {
        return saveBtn;
    }

    @FindBy(xpath = "html/body/div[2]/div/div[2]/div/div/div/div/div[2]/div[6]/div/div/button[2]")
    private WebElement cancelBtn;

    public WebElement getCancelBtn() {
        return cancelBtn;
    }
    //Cancel can return JS Alert
    //Logic to handle alert pop up
    public void acceptCancel() {
        getCancelBtn().click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public void openStudentDemo() {
        if (getStudentDemo().isDisplayed()||getStudentDemo().isEnabled())
            getStudentDemo().click();
        else System.out.println("Element not visible");
    }

    public void editStudentInfo() {
        getPatientGrade().clear();
        getPatientGrade().sendKeys("10");
        getPatientDOB().clear();
        getPatientDOB().sendKeys("01/01/2010");
        getPatientFirstName().clear();
        getPatientFirstName().sendKeys("Test");
        getPatientLastName().clear();
        getPatientLastName().sendKeys("More");
        getPatientMiddleName().clear();
        getPatientMiddleName().sendKeys("Nurse");
    }

    public void editStudentAddress() {
        getPatientStreetNum().clear();
        getPatientStreetNum().sendKeys("123");
        getPatientStreetName().clear();
        getPatientStreetName().sendKeys("Main St.");
        getPatientZipCode().clear();
        getPatientZipCode().sendKeys("85281");
        getPatientPhone().clear();
        getPatientPhone().sendKeys("4807458761");
        getPatientEmail().clear();
        getPatientEmail().sendKeys("autoTest123@stchome.com");
    }

    public void editGuardian1() {
        getGuardian1Name().clear();
        getGuardian1Name().sendKeys("Mister Clean");
        getGuardian1Phone().clear();
        getGuardian1Phone().sendKeys("4808008181");
        getGuardianStreetNum().clear();
        getGuardianStreetNum().sendKeys("123");
        getGuardianStreetName().clear();
        getGuardianStreetName().sendKeys("Main St.");
        getGuardianZipCode().clear();
        getGuardianZipCode().sendKeys("85281");
    }
}
