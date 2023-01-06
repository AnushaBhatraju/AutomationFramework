package pageClassPackage;

import basePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilityPackage.UtilsClass;

import java.io.IOException;
import java.util.logging.Logger;

public class HomePage  extends BaseClass {


    @FindBy(xpath = "//img[@id=\"logo\"]")
    WebElement wbqa;
    @FindBy(xpath = "//button[@id=\"headerfblogin\"]")
    WebElement FreeStudentAcecess;
    @FindBy(xpath = "//a[@id=\"wblhead\"]")
    WebElement wbl;
    @FindBy(xpath = "//*[@id=\"loginButton\"]")
    WebElement loginbtn;

    public HomePage() {
        PageFactory.initElements(driver, this);
        logger= Logger.getLogger(String.valueOf(HomePage.class));
        logger.info("--------initialising logger---------");
    }
    public String verifyTitle() {
    String Title=driver.getTitle();
        return Title;
    }
    public boolean verifyWbl(){
        boolean logo=wbl.isDisplayed();
        return logo;
    }
   public boolean verifyStudentAcecess(){
        boolean student =FreeStudentAcecess.isDisplayed();
        return student;
    }
   public LoginPage verifyLoginPage()  {
        loginbtn.click();
        return new LoginPage();
   }










}