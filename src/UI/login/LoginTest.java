package Login;

import com.stc.roster.po.BaseSetup;
import com.stc.roster.po.DataProviders;
import com.stc.roster.po.LoginPO;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseSetup {

    WebDriver driver;


    @BeforeClass
    public void setUp() throws IOException {
        try {
            driver = initializeDriver();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test(dataProvider = "Authentication", dataProviderClass = DataProviders.class)
    public void validLoginTest(String user, String pw) throws IOException, InterruptedException {
        LoginPO po = new LoginPO(driver);
        po.loginUser(user, pw);
    }

    @Test(dataProvider = "Authentication", dataProviderClass = DataProviders.class)
    public void invalidLoginTest(String user, String pw) throws IOException, InterruptedException {
        LoginPO po = new LoginPO(driver);
        po.loginUser(user, pw);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
