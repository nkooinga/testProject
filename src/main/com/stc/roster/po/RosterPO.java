package com.stc.roster.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

//    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(id = "student-searchEnter name, ID, DOB, etc")
    private WebElement studentSearch;

    public WebElement getStudentSearch() {
        return studentSearch;
    }
    //  Status Filter
    @FindBy(xpath = ".//*[@id='app-content']/div[2]/div/div[2]/div/div[1]/div[4]/div/span[1]/span/span/div/div/div")
    private WebElement statusFilter;

    public WebElement getStatusFilter() {
        return statusFilter;
    }

    @FindBy(xpath = ".//*[@id='listBox1']/li[1]/div")
    private WebElement anyStatus;

    public WebElement getAnyStatus() {
        return anyStatus;
    }

    @FindBy(xpath = ".//*[@id='listBox1']/li[2]/div")
    private WebElement dueNowStatus;

    public WebElement getDueNowStatus() {
        return dueNowStatus;
    }

    @FindBy(xpath = ".//*[@id='listBox1']/li[3]/div")
    private WebElement pastDueStatus;

    public WebElement getPastDueStatus() {
        return pastDueStatus;
    }

    @FindBy(xpath = ".//*[@id='listBox1']/li[4]/div")
    private WebElement upToDateStatus;

    public WebElement getUpToDateStatus() {
        return upToDateStatus;
    }

    @FindBy(xpath = ".//*[@id='listBox1']/li[5]/div")
    private WebElement optionalStatus;

    public WebElement getOptionalStatus() {
        return optionalStatus;
    }

    @FindBy(xpath = ".//*[contains(text(), 'Conditional')]")
    private WebElement conditionalStatus;

    public WebElement getConditionalStatus() {
        return conditionalStatus;
    }

    @FindBy(xpath = ".//*[contains(text(), 'Not Complete')]")
    private WebElement notCompleteStatus;

    public WebElement getNotCompleteStatus() {
        return notCompleteStatus;
    }

    @FindBy(xpath = ".//*[contains(text(), 'Complete')]")
    private WebElement completeStatus;

    public WebElement getCompleteStatus() {
        return completeStatus;
    }

    @FindBy(className = "dqouFe")
    private WebElement rosterGradeFilter;

    public WebElement getRosterGradeFilter() {
        return rosterGradeFilter;
    }

    //  Grade Filter Elements
    @FindBy(xpath = ".//*[@id='listBox2']/li[1]/div")
    private WebElement rosterAnyGrade;

    public WebElement getRosterAnyGrade() {
        return rosterAnyGrade;
    }

    @FindBy(xpath = ".//*[@id='listBox2']/li[2]/div")
    private WebElement rosterFirstGrade;

    public WebElement getRosterFirstGrade() {
        return rosterFirstGrade;
    }

    @FindBy(xpath = ".//*[@id='listBox2']/li[3]/div")
    private WebElement rosterSecondGrade;

    public WebElement getRosterSecondGrade() {
        return rosterSecondGrade;
    }

    @FindBy(xpath = ".//*[@id='listBox2']/li[4]/div")
    private WebElement rosterThirdGrade;

    public WebElement getRosterThirdGrade() {
        return rosterThirdGrade;
    }

    @FindBy(xpath = ".//*[@id='listBox2']/li[5]/div")
    private WebElement rosterFourthGrade;

    public WebElement getRosterFourthGrade() {
        return rosterFourthGrade;
    }

    @FindBy(xpath = ".//*[@id='listBox2']/li[6]/div")
    private WebElement rosterFifthGrade;

    public WebElement getRosterFifthGrade() {
        return rosterFifthGrade;
    }

    @FindBy(xpath = ".//*[@id='listBox2']/li[7]/div")
    private WebElement rosterSixthGrade;

    public WebElement getRosterSixthGrade() {
        return rosterSixthGrade;
    }

    @FindBy(xpath = ".//*[@id='listBox2']/li[8]/div")
    private WebElement rosterSeventhGrade;

    public WebElement getRosterSeventhGrade() {
        return rosterSeventhGrade;
    }

    @FindBy(xpath = ".//*[@id='listBox2']/li[9]/div")
    private WebElement rosterEigthGrade;

    public WebElement getRosterEigthGrade() {
        return rosterEigthGrade;
    }

    @FindBy(xpath = ".//*[@id='listBox2']/li[10]/div")
    private WebElement rosterNinthGrade;

    public WebElement getRosterNinthGrade() {
        return rosterNinthGrade;
    }

    @FindBy(xpath = ".//*[@id='listBox2']/li[11]/div")
    private WebElement rosterTenthGrade;

    public WebElement getRosterTenthGrade() {
        return rosterTenthGrade;
    }

    @FindBy(xpath = ".//*[@id='listBox2']/li[12]/div")
    private WebElement rosterEleventhGrade;

    public WebElement getRosterEleventhGrade() {
        return rosterEleventhGrade;
    }

    @FindBy(xpath = ".//*[@id='listBox2']/li[13]/div")
    private WebElement rosterTwelfthGrade;

    public WebElement getRosterTwelfthGrade() {
        return rosterTwelfthGrade;
    }

    @FindBy(id = "listBox3")
    private WebElement sortBy;

    public WebElement getSortBy() {
        return sortBy;
    }

    @FindBy(className = "Add New Student")
    private WebElement addNewStudentBtn;

    public WebElement getAddNewStudentBtn() {
        return addNewStudentBtn;
    }

    @FindBy(className = "Update Roster")
    private WebElement updateRosterBtn;

    public WebElement getUpdateRosterBtn() {
        return updateRosterBtn;
    }
    //Student Specific Elements
    @FindBy(className = "glyphicon-pencil")
    private WebElement studentDemo;

    public WebElement getStudentDemo() {
        return studentDemo;
    }

    @FindBy(className = "hNZDpO")
    private WebElement patientStatus;

    public WebElement getPatientStatus() {
        return patientStatus;
    }

    @FindBy(linkText = "vaccination")
    private WebElement vaccSummaryPage;

    public WebElement getVaccSummaryPage() {
        return vaccSummaryPage;
    }

    @FindBy(linkText = "form")
    private WebElement cisForm;

    public WebElement getCisForm() {
        return cisForm;
    }

    @FindBy(id = "grade")
    private WebElement gradeLevel;

    public WebElement getGradeLevel() {
        return gradeLevel;
    }

    @FindBy(id = "forecastStatus")
    private WebElement forecastStatus;

    public WebElement getForecastStatus() {
        return forecastStatus;
    }

    @FindBy(className = "glyphicon-chevron-right")
    private WebElement nextRosterPage;

    public WebElement getNextRosterPage() {
        return nextRosterPage;
    }

    public void statusFilterSelect() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        wait.until(ExpectedConditions.elementToBeClickable(getStatusFilter()));
        getStatusFilter().click();
        Thread.sleep(100);
    }

    public void anyStatusSelect() throws InterruptedException {
        statusFilterSelect();
        getAnyStatus().click();
        Thread.sleep(500);
    }

    public void dueNowStatusSelect() throws InterruptedException {
        statusFilterSelect();
        getDueNowStatus().click();
        Thread.sleep(500);
//        Assert.assertEquals("Due Now", getPatientStatus());
    }

    public void pastDueStatusSelect() throws InterruptedException {
        statusFilterSelect();
        getPastDueStatus().click();
        Thread.sleep(500);
//        Assert.assertEquals("Past Due", getPatientStatus());
    }

    public void upToDateStatusSelect() throws InterruptedException {
        statusFilterSelect();
        getUpToDateStatus().click();
        Thread.sleep(500);
//        Assert.assertEquals("Up to Date", getPatientStatus());
    }

    public void optionalStatusSelect() throws InterruptedException {
        statusFilterSelect();
        getOptionalStatus().click();
        Thread.sleep(500);
//        Assert.assertEquals("Optional", getPatientStatus());
    }

    public void conditionalStatusSelect() throws InterruptedException {
        statusFilterSelect();
        getConditionalStatus().click();
//        Assert.assertEquals("Conditional", getPatientStatus());
    }

    public void notCompleteStatusSelect() throws InterruptedException {
        statusFilterSelect();
        getNotCompleteStatus().click();
//        Assert.assertEquals("Not Complete", getPatientStatus());
    }

    public void completeStatusSelect() throws InterruptedException {
        statusFilterSelect();
        getCompleteStatus().click();
//        Assert.assertEquals("Complete", getPatientStatus());
    }

    public void gradeFilterSelect() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(getRosterGradeFilter()));
        getRosterGradeFilter().click();
        Thread.sleep(500);
    }

    public void firstGradeSelect() throws InterruptedException {
        gradeFilterSelect();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(getRosterGradeFilter()));
        getRosterFirstGrade().click();
    }

    public void secondGradeSelect() throws InterruptedException {
        gradeFilterSelect();
        getRosterSecondGrade().click();
        Thread.sleep(500);
    }

    public void thirdGradeSelect() throws InterruptedException {
        gradeFilterSelect();
        getRosterThirdGrade().click();
        Thread.sleep(500);
    }

    public void fourthGradeSelect() throws InterruptedException {
        gradeFilterSelect();
        getRosterFourthGrade().click();
        Thread.sleep(500);
    }

    public void fifthGradeSelect() throws InterruptedException {
        gradeFilterSelect();
        getRosterFifthGrade().click();
        Thread.sleep(500);
    }
}
