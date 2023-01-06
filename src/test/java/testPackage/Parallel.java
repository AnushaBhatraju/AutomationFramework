package testPackage;

import org.apache.poi.hpsf.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilityPackage.UtilsClass;

import java.util.concurrent.TimeUnit;

public class Parallel {

        WebDriver driver;
        Property prop;
        @BeforeTest
        @Parameters("browser")
        public void driverInitialisation(String browser) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhatr\\IdeaProjects\\AutomationFramework" +
                        "\\src\\main\\resources\\Browsers\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("FireFox")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\bhatr\\IdeaProjects\\AutomationFramework" +
                        "\\src\\main\\resources\\Browsers\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }

        @Test
        public void setUp() {


            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(UtilsClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(UtilsClass.IMPLICT_WAIT, TimeUnit.SECONDS);
            driver.get("https://google.com");

        }
        @AfterTest
        public void teardown(){
            driver.quit();
        }




    }





