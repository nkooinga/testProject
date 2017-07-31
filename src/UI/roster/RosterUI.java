package roster;

import com.aventstack.extentreports.Status;
import com.stc.roster.po.BaseSetup;
import com.stc.roster.po.DataProviders;
import com.stc.roster.po.LoginPO;
import com.stc.roster.po.RosterPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reporting.ExtentUtil;

import java.io.IOException;

/**
 * Created by nkooinga on 6/12/2017.
 */
public class RosterUI extends BaseSetup {

    WebDriver driver;
    LoginPO lpo;
    RosterPO rpo;
    ExtentUtil eu;

    @BeforeClass
    public void setUp() throws IOException {

        try {
            driver = initializeDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 0, dataProvider = "Authentication", dataProviderClass = DataProviders.class)
    public void rosterLogin(String user, String pw) throws IOException, InterruptedException {
        lpo = new LoginPO(driver);
        lpo.loginUser(user, pw);
        Thread.sleep(3000);

    }

    @Test(priority = 1, dataProvider = "Roster Search", dataProviderClass = DataProviders.class)
    public void validRosterSearch(String studentSearch) throws InterruptedException {
        rpo = new RosterPO(driver);
//        rpo.dueNowStatusSelect();
//        rpo.getStudentSearch().clear();
//        rpo.getStudentSearch().sendKeys(studentSearch);
//        rpo.pastDueStatusSelect();
//        rpo.getStudentSearch().clear();
//        rpo.getStudentSearch().sendKeys(studentSearch);
//        rpo.upToDateStatusSelect();
//        rpo.getStudentSearch().clear();
//        rpo.getStudentSearch().sendKeys(studentSearch);
//        rpo.optionalStatusSelect();
//        rpo.getStudentSearch().clear();
//        rpo.getStudentSearch().sendKeys(studentSearch);
        rpo.conditionalStatusSelect();
        eu.fetchTest().log(Status.INFO, "Searching by conditional status.");
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        eu.fetchTest().log(Status.INFO, studentSearch);
        rpo.notCompleteStatusSelect();
        eu.fetchTest().log(Status.INFO, "Searching by NOT complete status.");
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        eu.fetchTest().log(Status.INFO, studentSearch);
        rpo.completeStatusSelect();
        eu.fetchTest().log(Status.INFO, "Searching by complete status.");
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        eu.fetchTest().log(Status.INFO, studentSearch);
        rpo.anyStatusSelect();
        rpo.getStudentSearch().clear();

    }

    @Test(priority = 2, dataProvider = "Roster Search", dataProviderClass = DataProviders.class)
    public void invalidRosterSearch(String studentSearch) throws InterruptedException {
        rpo = new RosterPO(driver);
//        rpo.dueNowStatusSelect();
//        rpo.getStudentSearch().clear();
//        rpo.getStudentSearch().sendKeys(studentSearch);
//        rpo.pastDueStatusSelect();
//        rpo.getStudentSearch().clear();
//        rpo.getStudentSearch().sendKeys(studentSearch);
//        rpo.upToDateStatusSelect();
//        rpo.getStudentSearch().clear();
//        rpo.getStudentSearch().sendKeys(studentSearch);
//        rpo.optionalStatusSelect();
        rpo.conditionalStatusSelect();
        eu.fetchTest().log(Status.INFO, "Searching by conditional status.");
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        eu.fetchTest().log(Status.INFO, studentSearch);
        rpo.notCompleteStatusSelect();
        eu.fetchTest().log(Status.INFO, "Searching by NOT complete status.");
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        eu.fetchTest().log(Status.INFO, studentSearch);
        rpo.completeStatusSelect();
        eu.fetchTest().log(Status.INFO, "Searching by complete status.");
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        eu.fetchTest().log(Status.INFO, studentSearch);
        rpo.anyStatusSelect();
        rpo.getStudentSearch().clear();
    }

//  Need to refactor to account for change in grade values
//    @Test(priority = 3)
//    public void rosterGradeFilter() throws InterruptedException {
//        rpo = new RosterPO(driver);
//        rpo.firstGradeSelect();
//        rpo.secondGradeSelect();
//        rpo.thirdGradeSelect();
//        rpo.fourthGradeSelect();
//        rpo.fifthGradeSelect();
//    }

    @Test(priority = 4)
    public void addNewStudent() {
        rpo = new RosterPO(driver);
        eu.fetchTest().log(Status.INFO, "Adding new student.");
        rpo.getAddNewStudentBtn().click();
    }

    @Test(priority = 4)
    public void updatedRoster() {
        rpo = new RosterPO(driver);
        eu.fetchTest().log(Status.INFO, "Updating Roster.");
        rpo.getUpdateRosterBtn().click();

    }

    @Test(priority = 5)
    public void nextRosterListPage() {
        rpo = new RosterPO(driver);
        eu.fetchTest().log(Status.INFO, "Selecting next roster page.");
        rpo.getNextRosterPage().click();
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

