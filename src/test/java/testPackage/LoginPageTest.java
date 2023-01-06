package testPackage;

import basePackage.BaseClass;
import org.apache.xmlbeans.impl.jam.JConstructor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.Utils;
import pageClassPackage.HomePage;
import pageClassPackage.LandingPage;
import pageClassPackage.LoginPage;
import utilityPackage.UtilsClass;

import java.io.IOException;

import static org.apache.poi.hssf.usermodel.HeaderFooter.page;

public class LoginPageTest extends BaseClass {
    LoginPage loginPage;
    HomePage home;
    LandingPage land;


    //Constructor
    public LoginPageTest()
    {
        super();                  //calling parent class constructor ,it will read the properties file
    }
    @BeforeMethod
    public void setup()  {
        initialization();    //it will initialise the browser,and driver with above webElements.
        home=new HomePage();
        loginPage=new LoginPage();
        land=new LandingPage();

        home.verifyLoginPage();//click the login button to go to the next page every time so we have to put in before method

    }
    @Test
    public void validateLoginPageTitle(){
        String actual=loginPage.verifyTitle();
        String expected="QA/QE/SDET Training.";
        Assert.assertEquals(actual,expected);
    }
@DataProvider
        public Object[][] LoginDataDriven(){
        Object[][] data= UtilsClass.getExcelData("Book1.xlsx","sheet1");
        return data;
}
@Test(dataProvider = "LoginDataDriven")
       public void loginDataTest(String username,String password) {
    loginPage.verifyLoginButton(username, password);
}




    //@Test
        public LandingPage validateLoginbutton()  {
         land=loginPage.verifyLoginButton(prop.getProperty("username"),prop.getProperty("password"));

        return new LandingPage();

    }

  // @Test

   public void verifyRegisterTest(){
        boolean reg=loginPage.verifyRegister();
        Assert.assertTrue(reg);
    }



       @AfterMethod
    public  void tearDown(){
        driver.close();
       }

}











