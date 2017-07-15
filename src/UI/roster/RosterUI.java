//package roster;
//
//import com.stc.roster.po.RosterPO;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
///**
// * Created by nkooinga on 6/12/2017.
// */
//public class RosterUI extends RosterPO() {
//
////  Tests for IWEBMODERN-6
//    @BeforeSuite
//    public void rosterPageAccess(){
////  Create variable for driver instantiation, driver properties, and URL to get
//        driver.get("URL HERE");
//        driver.manage().window().maximize();
//        Assert.assertEquals("URL",driver.getTitle());
//
//        }
//
//    @Test
//    public void
//
////  Get forecast status
//    @Test
//    public void getForecastStatus(){
//        RosterPO ro = new RosterPO(driver);
////  Need to create endpoint variable once it is available.
//        if(ro.forecastStatus()!= null){
//        System.out.println("Status is present: "  + ro.forecastStatus);
//        } else {
//            System.out.println("Status is NOT present")
//        }
//// screenshot functionality
//        File srcImage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//        FileUtils.copyFile(srcImage,new File("PATH HERE"));
//        ExtentUtil.fetchTest().addScreenCaptureFromPath("PATH HERE");
//        driver.quit();
//
//        }
//
//
//}
