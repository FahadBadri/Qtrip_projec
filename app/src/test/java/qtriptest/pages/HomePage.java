package qtriptest.pages;

import net.bytebuddy.asm.Advice.This;
import qtriptest.SeleniumWrapper;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
        
    RemoteWebDriver driver;
    // String Url = "https://qtripdynamic-qa-frontend.vercel.app/";
       // WebDriverWait wait = new WebDriverWait(driver, 10);
    public HomePage(RemoteWebDriver driver){
        this.driver= driver;
        // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
         PageFactory.initElements(this.driver, this);
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

    }

    public void navigatetoHomePage(){
        
        driver.get("https://qtripdynamic-qa-frontend.vercel.app/");
        
    }

    @FindBy(xpath= "//div[contains(text(),'Logout')]")
    WebElement LogOutBtn;

    @FindBy(xpath ="//a[contains(text(),'Register')]")
    WebElement RegisteBtn;

    @FindBy(xpath= "//input[@class='hero-input']")
    WebElement SearchBtn;

    @FindBy(xpath = "//h5[contains(text(),'No City found')]")
    WebElement CityNotFound;

    @FindBy(id ="results")
    WebElement resultcity;


    public void ClickOnRegister() throws InterruptedException{
       // RegisteBtn.click();
       SeleniumWrapper.click(RegisteBtn, driver);
    }

    public boolean isUserLoggedIn(){
        try{
                if(LogOutBtn.isDisplayed()){
                    return true;
                }else{
                    return false;
                }
        }catch(Exception e){
            System.out.println("Element Not Found");
            return false;
        }
  
    }
    
    public void  searchCity(String city) throws InterruptedException {
           // Thread.sleep(2000);
           SeleniumWrapper.sendKeys(SearchBtn, city);
          Thread.sleep(1000);
           driver.findElement(By.xpath("//input[@class='hero-input']")).sendKeys(Keys.BACK_SPACE);
           //SearchBtn.sendKeys(city);
           
           // SearchBtn.click();
         //   Thread.sleep(3000);
           // SearchBtn.clear();
           
        }
       
       
        public boolean verifyCityNotFound(){
        try{
            Thread.sleep(2000);
            if(CityNotFound.isDisplayed())
            return true;
        }catch(Exception e){
            return false;

        }
      return false;
    }

    public boolean AssertAutoCompleteText(){

        if(resultcity.isDisplayed()){
            return true;
        }else{
            return false;
        }
    
    }

    public boolean SelectCity() throws InterruptedException{
       if(resultcity.isDisplayed()){
       // driver.findElement(By.xpath("//a/li")).click();
      SeleniumWrapper.click(resultcity, driver);
      // resultcity.click();
       }else{
        return false;
       }
       
       return true;
        
    }


   
    
}













