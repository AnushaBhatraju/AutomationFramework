package testPackage;

import basePackage.BaseClass;
import org.apache.poi.hpsf.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageClassPackage.*;
import utilityPackage.UtilsClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LandingPageTest extends BaseClass {

    HomePage hp;
    LandingPage landingPage;
    LoginPage loginPage;
    SchedulePage sp;
    ChangePassWordPage cp;


    public LandingPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        hp = new HomePage();
        landingPage = new LandingPage();
        loginPage = new LoginPage();
        sp = new SchedulePage();
        cp = new ChangePassWordPage();
        hp.verifyLoginPage();

    }

    @Test
    public void validateTitleTest() {
        String actual = landingPage.verifyTitle();
        String expected = "QA/QE/SDET Training.";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void verifyScheduleTest() throws IOException {
        landingPage.validateSchedule();
    }

    @Test
    public void verifyHomeBtnTest() {
        landingPage.verifyHomeButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}