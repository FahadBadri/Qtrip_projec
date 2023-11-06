package qtriptest.pages;

import qtriptest.SeleniumWrapper;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegisterPage {
    RemoteWebDriver driver;
    String Url = "https://qtripdynamic-qa-frontend.vercel.app/pages/register/";

    public  String lastgeneratedUsername = "";
    
    @FindBy (name="email")
    WebElement usernameTextBx;

    @FindBy (name="password")
    WebElement passwordTextBx;

    @FindBy (name="confirmpassword")
    WebElement confirmPasswordBx;

    @FindBy (xpath="//button[contains(text(),'Register Now')]")
    WebElement RegisterNowButton;
    public String lastgeneratedUserName;

    public RegisterPage(RemoteWebDriver driver){
        this.driver = driver;
        // PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);


    }
 


    public void navigateToRegistrationPage(){
        if(!driver.getCurrentUrl().equals(this.Url)){
            driver.get(this.Url);
        }

    }

    

    public void RegisterNewUser(String Username, String password, Boolean generateRandomUsername) throws InterruptedException{

       
        if(generateRandomUsername){ 
            Username = UUID.randomUUID().toString()+"@gmail.com";
}
            lastgeneratedUsername= Username;
            SeleniumWrapper.sendKeys(usernameTextBx, Username);

           // usernameTextBx.clear();
           // usernameTextBx.sendKeys(Username);
              
           SeleniumWrapper.sendKeys(passwordTextBx, password);

           // passwordTextBx.clear();
           // passwordTextBx.sendKeys(password);

           // confirmPasswordBx.clear();
           SeleniumWrapper.sendKeys(confirmPasswordBx, password);
           // confirmPasswordBx.sendKeys(password);
           
           // RegisterNowButton.click();
            Thread.sleep(3000);
            SeleniumWrapper.click(RegisterNowButton, driver);
           
        }

      

    
       
    public void checkIfUserIsOnLoginPage() {
    if (driver.getCurrentUrl().endsWith("/login")) {
        driver.close();
    }
}
        
    }





    

