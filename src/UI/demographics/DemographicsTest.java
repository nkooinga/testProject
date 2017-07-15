package demographics;

import com.stc.roster.po.BaseSetup;
import com.stc.roster.po.DataProviders;
import com.stc.roster.po.DemographicsPO;
import com.stc.roster.po.LoginPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DemographicsTest extends BaseSetup {
    WebDriver driver;
    LoginPO lpo;
    DemographicsPO dpo;


    @BeforeClass
    public void setUp() throws IOException {
        try {
            driver = initializeDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test(dataProvider = "Authentication", dataProviderClass = DataProviders.class)
    public void editAllDemoFields(String user, String pw) throws IOException, InterruptedException {
        lpo = new LoginPO(driver);
        lpo.loginUser(user, pw);
        Thread.sleep(3000);
        dpo = new DemographicsPO(driver);
        dpo.openStudentDemo();
        dpo.getEditBtn().click();
        dpo.editStudentInfo();
        dpo.editStudentAddress();
        dpo.editGuardian1();
//        Will need to change below once DB is attached.
        dpo.acceptCancel();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
