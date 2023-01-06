package pageClassPackage;

import basePackage.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilityPackage.UtilsClass;

import java.io.IOException;

public class LandingPage extends BaseClass {
    @FindBy(xpath = "//*[@id=\"logout\"]")
    WebElement Logout;

    @FindBy(xpath = "//*[@id=\"navbar-collapse\"]/ul/li[2]/a")
    WebElement Schedule;

    @FindBy(xpath ="//*[@id=\"navbar-collapse\"]/ul/li[1]/a")
    WebElement Homebtn;


    public LandingPage() {
        PageFactory.initElements(driver,this);
    }
      public String verifyTitle(){
        String title=driver.getTitle();
        return title;

      }
    public void verifyLogOut(){
    boolean logout=Logout.isDisplayed();
    }
    public void validateSchedule() throws IOException {
        Schedule.click();
        UtilsClass.takeScreenShotAtEndOfTest();
    }
public void verifyHomeButton(){
    Homebtn.click();
}


    }



