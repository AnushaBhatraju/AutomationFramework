package testPackage;

import basePackage.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClassPackage.HomePage;
import pageClassPackage.LoginPage;
import utilityPackage.UtilsClass;

import java.io.IOException;

public class HomePageTest extends BaseClass {
    HomePage home;
    LoginPage login;

    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setup(){
        initialization();
        home=new HomePage();
    }
    @Test(priority = 1)
     public void verifyTitleTest() throws IOException {
      String actual= home.verifyTitle();
      String expected ="QA/QE/SDET Training.";
      Assert.assertEquals(actual,expected);
      logger.info("getting the title");
        UtilsClass.takeScreenShotAtEndOfTest();
}
/*@Test(priority = 2)
     public void verifyWblTest(){
      boolean logo=home.verifyWbl();
      Assert.assertTrue(logo);
}*/
@Test(priority = 3)
    public void verifyStudentAcecessTest(){
        boolean student=home.verifyStudentAcecess();
        Assert.assertTrue(student);
        logger.info("student acess  is visible");
}
/*@Test(priority = 4)
    public void verifyLoginPage(){

        home.verifyLoginPage();
        logger.info("we are in loginpage");}*/

@AfterMethod
    public void tearDown(){
        driver.quit();
        logger.info("driver is closed"); }





}
