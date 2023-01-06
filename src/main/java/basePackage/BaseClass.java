package basePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hpsf.Property;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilityPackage.UtilsClass;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.AuthProvider;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {
public static WebDriver driver;
public static Properties prop;
public static Logger logger=null;  //declaring,and initialisation

public BaseClass() {
    try{
    prop=new Properties();
    FileInputStream ip =new FileInputStream("C:\\Users\\bhatr\\IdeaProjects\\AutomationFramework" +
            "\\src\\main\\java\\configPackage\\config.properties");
    prop.load(ip);
    }
    catch (IOException E) {
        E.printStackTrace();
    }
//giving the path to log4j through the constuctor
    String log4jPath = System.getProperty("C:\\Users\\bhatr\\IdeaProjects\\AutomationFramework\\src\\main\\resources\\log4j.properties");
    PropertyConfigurator.configure(log4jPath);
   // catch (NullPointerException e){

    //}
}
public static void initialization(){
    String browserName = prop.getProperty("Browser");
    //logger.info("------browser is starting------------");
    WebDriverManager.chromedriver().setup();
    if(browserName.equals("chrome")){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\bhatr\\IdeaProjects\\AutomationFramework" +
                "\\src\\main\\resources\\Browsers\\chromedriver.exe");
        driver=new ChromeDriver();
       // logger.info("chrome browser is started");
    }
    else if (browserName.equals("gecko")) {
        System.setProperty("webdriver.gecko.driver", "");
        driver = new FirefoxDriver();
       // logger.info("firefox driver is started");
    }
     driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
     driver.manage().timeouts().pageLoadTimeout(UtilsClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
     driver.manage().timeouts().implicitlyWait(UtilsClass.IMPLICT_WAIT,TimeUnit.SECONDS);
     driver.get(prop.getProperty("url"));
}

}
























