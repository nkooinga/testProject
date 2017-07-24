package roster;

import com.stc.roster.po.BaseSetup;
import com.stc.roster.po.DataProviders;
import com.stc.roster.po.LoginPO;
import com.stc.roster.po.RosterPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by nkooinga on 6/12/2017.
 */
public class RosterUI extends BaseSetup {

    WebDriver driver;
    LoginPO lpo;
    RosterPO rpo;

    @BeforeClass
    public void setUp() throws IOException {

        try {
            driver = initializeDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 0, dataProvider = "authentication", dataProviderClass = DataProviders.class)
    public void rosterLogin(String user, String pw) throws IOException, InterruptedException {
        lpo = new LoginPO(driver);
        lpo.loginUser(user, pw);
        Thread.sleep(3000);

    }

    @Test(priority = 1, dataProvider = "Roster Search", dataProviderClass = DataProviders.class)
    public void validRosterSearch(String studentSearch) throws InterruptedException {
        rpo = new RosterPO(driver);
        rpo.dueNowStatusSelect();
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        rpo.pastDueStatusSelect();
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        rpo.upToDateStatusSelect();
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        rpo.optionalStatusSelect();
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        rpo.getStudentSearch().clear();

    }

    @Test(priority = 2, dataProvider = "Roster Search", dataProviderClass = DataProviders.class)
    public void invalidRosterSearch(String studentSearch) throws InterruptedException {
        rpo = new RosterPO(driver);
        rpo.dueNowStatusSelect();
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        rpo.pastDueStatusSelect();
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        rpo.upToDateStatusSelect();
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        rpo.optionalStatusSelect();
        rpo.getStudentSearch().clear();
        rpo.getStudentSearch().sendKeys(studentSearch);
        rpo.getStudentSearch().clear();
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

