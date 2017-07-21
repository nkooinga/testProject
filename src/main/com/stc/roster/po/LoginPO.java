package com.stc.roster.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.IOException;

public class LoginPO {

    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }
    //  USERNAME logic
    @FindBy(id = "username")
    private WebElement username;

    //Update to datadriven model on auth is completed
    public WebElement getUsername() {
        return username;
    }

    @FindBy(id = "password")
    private WebElement password;

    public WebElement getPassword() {
        return password;
    }


    @FindBy(id = "kc-login")
    private WebElement loginBtn;

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public void signInBtn() {
        getLoginBtn().click();
//        if(loginBtn.isDisplayed()||loginBtn.isEnabled())
//            loginBtn.click();
//        else System.out.println("Element not displayed/enabled");
    }


//    public void enterUsername(String user) {
//        getUsername().sendKeys(user);
//    }
//
//    public void enterPassword(String pw) {
//        getPassword().sendKeys(pw);
//    }

    public String getURL() {
        String getURL= driver.getCurrentUrl();
        System.out.println(getURL);
        return getURL;
    }

    public boolean verifySignInURL() {
        String verifyURL = "stc-keycloak";
        return driver.getCurrentUrl().contains("stc-keycloak");
    }

    public void loginUser(String user, String pw) throws IOException, InterruptedException {
        verifySignInURL();
        Thread.sleep(2000);
        getUsername().sendKeys(user);
        getPassword().sendKeys(pw);
        signInBtn();
        Thread.sleep(5000);
        getURL();
    }
//
////  Adding Screenshot capabilities
//        Thread.sleep(1000);
//        File loginSS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(loginSS, new File("testImages/loginSS"));
////  Use this for screenshots on logs
////        ExtentUtil.fetchTest().info("Succesful Login", MediaEntityBuilder.createScreenCaptureFromPath("testImages/loginSS").build());
////  Use this for screenshots on tests
//        ExtentUtil.fetchTest().addScreenCaptureFromPath("testImages/loginSS");
//        return driver.getCurrentUrl().contains("aws");
//    }
}
