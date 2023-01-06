package pageClassPackage;

import basePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginbtn;
    @FindBy(xpath = "//button[@id='register']")
    WebElement register;

    public  LoginPage(){
    PageFactory.initElements(driver,this);
    }
    public String verifyTitle(){
        String title=driver.getTitle();
        return title;
    }


   public Boolean verifyRegister(){
        boolean reg=register.isDisplayed();
        return reg;
  }
    public LandingPage verifyLoginButton(String un, String pwd){
        loginbtn.click();
        username.sendKeys(un);
        password.sendKeys(pwd);


        loginbtn.click();


        return new LandingPage();
    }

}
