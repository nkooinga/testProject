package demographics;

import com.aventstack.extentreports.Status;
import com.stc.roster.po.BaseSetup;
import com.stc.roster.po.DataProviders;
import com.stc.roster.po.DemographicsPO;
import com.stc.roster.po.LoginPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reporting.ExtentUtil;

import java.io.IOException;

import static reporting.ExtentUtil.fetchTest;

public class DemographicsTest extends BaseSetup {
    WebDriver driver;
    LoginPO lpo;
    DemographicsPO dpo;
    ExtentUtil eu;


    @BeforeClass
    public void setUp() throws IOException {
        try {
            driver = initializeDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //  Need city/state/notes
    @Test(dataProvider = "Authentication", dataProviderClass = DataProviders.class)
    public void editAllDemoFields(String user, String pw) throws IOException, InterruptedException {
        lpo = new LoginPO(driver);
        lpo.loginUser(user, pw);
        eu.fetchTest().log(Status.INFO, "Logging in");
        Thread.sleep(3000);
        dpo = new DemographicsPO(driver);
        dpo.openStudentDemo();
        eu.fetchTest().log(Status.INFO, "Student Demographics Edit");
        dpo.getEditBtn().click();
        dpo.editStudentInfo();
        dpo.editStudentAddress();
        dpo.editGuardian1();
//        Will need to change below once DB is attached.
        dpo.addPatientNotes();
        dpo.acceptCancel();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "Student Information", dataProviderClass = DataProviders.class)
    public void validInfoFields(String firstName, String lastName, String middleName) throws IOException, InterruptedException {
        dpo = new DemographicsPO(driver);
        dpo.openStudentDemo();
        dpo.getEditBtn().click();
        eu.fetchTest().log(Status.INFO, "Editing Student Information fields";
        dpo.getPatientFirstName().clear();
        dpo.getPatientFirstName().sendKeys(firstName);
        eu.fetchTest().log(Status.INFO, firstName);
        dpo.getPatientLastName().clear();
        dpo.getPatientLastName().sendKeys(lastName);
        eu.fetchTest().log(Status.INFO, lastName);
        dpo.getPatientMiddleName().clear();
        dpo.getPatientMiddleName().sendKeys(middleName);
        eu.fetchTest().log(Status.INFO, middleName);
        dpo.acceptCancel();
        Thread.sleep(1000);
    }
    @Test(dataProvider = "Student Information", dataProviderClass = DataProviders.class)
    public void invalidInfoFields(String firstName, String lastName, String middleName) throws IOException, InterruptedException {
        dpo = new DemographicsPO(driver);
        dpo.openStudentDemo();
        dpo.getEditBtn().click();
        dpo.getPatientFirstName().clear();
        dpo.getPatientFirstName().sendKeys(firstName);
        eu.fetchTest().log(Status.INFO, firstName);
        dpo.getPatientLastName().clear();
        dpo.getPatientLastName().sendKeys(lastName);
        eu.fetchTest().log(Status.INFO, lastName);
        dpo.getPatientMiddleName().clear();
        dpo.getPatientMiddleName().sendKeys(middleName);
        eu.fetchTest().log(Status.INFO, middleName);
//        takeScreenshot();
        dpo.acceptCancel();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "Student Birthdate", dataProviderClass = DataProviders.class)
    public void validBirthdate(String birthDate) throws InterruptedException {
        dpo = new DemographicsPO(driver);
        dpo.openStudentDemo();
        dpo.getEditBtn().click();
        eu.fetchTest().log(Status.INFO, "Editing Student DOB");
        dpo.getPatientDOB().clear();
        dpo.getPatientDOB().sendKeys(birthDate);
        eu.fetchTest().log(Status.INFO, birthDate);
        dpo.acceptCancel();
        Thread.sleep(1000);

    }

    @Test(dataProvider = "Student Birthdate", dataProviderClass = DataProviders.class)
    public void invalidBirthdate(String birthDate) throws InterruptedException {
        dpo = new DemographicsPO(driver);
        dpo.openStudentDemo();
        dpo.getEditBtn().click();
        eu.fetchTest().log(Status.INFO, "Editing Student DOB with invalid characters");
        dpo.getPatientDOB().clear();
        dpo.getPatientDOB().sendKeys(birthDate);
        eu.fetchTest().log(Status.INFO, birthDate);
        dpo.acceptCancel();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "Guardian Information", dataProviderClass = DataProviders.class)
    public void validGuardianInfo(String grdName, String grdPhone, String grdStNum, String grdStName, String grdZip) throws InterruptedException {
        dpo = new DemographicsPO(driver);
        dpo.openStudentDemo();
        dpo.getEditBtn().click();
        eu.fetchTest().log(Status.INFO, "Editing Guardian Information");
        dpo.getGuardian1Name().clear();
        dpo.getGuardian1Name().sendKeys(grdName);
        eu.fetchTest().log(Status.INFO, grdName);
        dpo.getGuardian1Phone().clear();
        dpo.getGuardian1Phone().sendKeys(grdPhone);
        eu.fetchTest().log(Status.INFO, grdPhone);
        dpo.getGuardianStreetNum().clear();
        dpo.getGuardianStreetNum().sendKeys(grdStNum);
        eu.fetchTest().log(Status.INFO, grdStNum);
        dpo.getGuardianStreetName().clear();
        dpo.getGuardianStreetName().sendKeys(grdStName);
        eu.fetchTest().log(Status.INFO, grdStName);
        dpo.getGuardianZipCode().clear();
        dpo.getGuardianZipCode().sendKeys(grdZip);
        eu.fetchTest().log(Status.INFO, grdZip);
        dpo.acceptCancel();
        Thread.sleep(1000);
    }

    @Test(dataProvider = "Guardian Information", dataProviderClass = DataProviders.class)
    public void invalidGuardianInfo(String grdName, String grdPhone, String grdStNum, String grdStName, String grdZip) throws InterruptedException{
        dpo = new DemographicsPO(driver);
        dpo.openStudentDemo();
        dpo.getEditBtn().click();
        eu.fetchTest().log(Status.INFO, "Editing Guardian Information");
        dpo.getGuardian1Name().clear();
        dpo.getGuardian1Name().sendKeys(grdName);
        eu.fetchTest().log(Status.INFO, grdName);
        dpo.getGuardian1Phone().clear();
        dpo.getGuardian1Phone().sendKeys(grdPhone);
        eu.fetchTest().log(Status.INFO, grdPhone);
        dpo.getGuardianStreetNum().clear();
        dpo.getGuardianStreetNum().sendKeys(grdStNum);
        eu.fetchTest().log(Status.INFO, grdStNum);
        dpo.getGuardianStreetName().clear();
        dpo.getGuardianStreetName().sendKeys(grdStName);
        eu.fetchTest().log(Status.INFO, grdStName);
        dpo.getGuardianZipCode().clear();
        dpo.getGuardianZipCode().sendKeys(grdZip);
        eu.fetchTest().log(Status.INFO, grdZip);
        dpo.acceptCancel();
        Thread.sleep(1000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
