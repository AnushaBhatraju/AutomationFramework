package basePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilityPackage.UtilsClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass2 {
    public static WebDriver driver;
    public static Properties prop;

    public BaseClass2() throws IOException {
      prop=new Properties();
        FileInputStream fi= new FileInputStream("C:\\Users\\bhatr\\IdeaProjects\\AutomationFramework\\src" +
                "\\main\\java\\configPackage\\config.properties");
        prop.load(fi);
    }
    public static void initialisation(){

        String browserName1=prop.getProperty("Browser");

        WebDriverManager.chromedriver().setup();
        if(browserName1.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","path of the chrome exe file");
            driver=new ChromeDriver();
        }
        else if(browserName1.equals("gecko")){
            System.setProperty("webdriver.firefox.driver","path of gecko driver");
            driver=new FirefoxDriver();
        }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(UtilsClass.IMPLICT_WAIT, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(UtilsClass.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
            driver.get(prop.getProperty("url"));
        }







    }


















