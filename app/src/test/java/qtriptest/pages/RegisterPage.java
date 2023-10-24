package qtriptest.pages;

import java.util.UUID;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    RemoteWebDriver driver;
    String Url = "https://qtripdynamic-qa-frontend.vercel.app/pages/register/";

    public String lastgeneratedUsername = "";
    
    @FindBy (name="email")
    WebElement usernameTextBx;

    @FindBy (name="password")
    WebElement passwordTextBx;

    @FindBy (name="confirmpassword")
    WebElement confirmPasswordBx;

    @FindBy (xpath="//button[contains(text(),'Register Now')]")
    WebElement RegisterNowButton;

    public RegisterPage(RemoteWebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
 


    public void navigateToRegistrationPage(){
        if(!driver.getCurrentUrl().equals(this.Url)){
            driver.get(this.Url);
        }

    }

    

    public void RegisterNewUser(String Username, String password,  Boolean generateRandomUsername) throws InterruptedException{

        // if(generateRandomUsername==true){
        //     Username = Username+UUID.randomUUID().toString();
        if(generateRandomUsername){ 
            Username = UUID.randomUUID().toString()+"@gmail.com";
}
            lastgeneratedUsername= Username;
            usernameTextBx.clear();
            usernameTextBx.sendKeys(Username);
            passwordTextBx.clear();
            passwordTextBx.sendKeys(password);
            confirmPasswordBx.clear();
            confirmPasswordBx.sendKeys(password);
            RegisterNowButton.click();
            Thread.sleep(5000);

           
        }

      

    
       
    public void checkIfUserIsOnLoginPage() {
    if (driver.getCurrentUrl().endsWith("/login")) {
        driver.close();
    }
}




        
    }





    

