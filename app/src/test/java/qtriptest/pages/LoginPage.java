package qtriptest.pages;

import qtriptest.SeleniumWrapper;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    RemoteWebDriver driver;
    String Url = "https://qtripdynamic-qa-frontend.vercel.app/pages/login/";
    public String lastgeneratedUsername = "";

    public LoginPage(RemoteWebDriver driver){
         this.driver=driver;
        // // PageFactory.initElements(this.driver,this);
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver,  10);
        PageFactory.initElements(ajax, this);

}
        public void navigatetoLoginPage(){
            // if(!driver.getCurrentUrl().equals(Url)){
            //     driver.get(Url);
            // }
            SeleniumWrapper.navigate(driver, Url);
        }

        @FindBy (name ="email") 
        WebElement email_Text_box;
        
        @FindBy (name= "password")
        WebElement password_Text_box;

        @FindBy (xpath= "//button[text()='Login to QTrip']")
        WebElement login_toqtrip_Button_box;
        
        @FindBy(xpath = "//div[text()='Logout']")
        WebElement log_out_button;
        
        @FindBy (xpath = "//a[text()='Login Here']")
        WebElement Login_here_verify;
       



        public void performLogin(String username, String password){
            try{
                // email_Text_box.sendKeys(username);
                // password_Text_box.sendKeys(password);
                // login_toqtrip_Button_box.click();
                // Thread.sleep(5000);
                SeleniumWrapper.sendKeys(email_Text_box, username);
               
                SeleniumWrapper.sendKeys(password_Text_box, password);
               
                SeleniumWrapper.click(login_toqtrip_Button_box, driver);

            }catch(Exception e){
                System.out.println(e);
            }


        }

        public boolean verifyLogin(){
            if(log_out_button.isDisplayed()){
                return true;
            }else{
                return false;
            }
        }

        
        // public boolean verifyLogOut(){
        //     if(Login_here_verify.isDisplayed()){
        //         return true;
        //     }else{
        //         return false;
        //     }
        // }


        // public void logout(){
        //     log_out_button.click();
        // }

        
    }

