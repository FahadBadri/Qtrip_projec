package qtriptest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.net.MalformedURLException;
import org.openqa.selenium.JavascriptExecutor;

public class SeleniumWrapper {
    // public static WebDriver driver;

    // public SeleniumWrapper(){
    //     SeleniumWrapper.driver = driver;
    // }

    // public static boolean click(WebElement element) {
    //     if(element.isDisplayed()){
    //         Actions action = new Actions(DriverSingleton.getDriiver());
    //         action.moveToElement(element).click().perform();
    //         return true;
    //     }else{
    //         return false;
    //     }
    // }
    public static boolean click(WebElement elementToClick, WebDriver driver) throws InterruptedException {
        if (elementToClick.isDisplayed()) {
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToClick);
                Thread.sleep(1500);
                elementToClick.click();
                return true;        
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }



    public static boolean sendKeys(WebElement inputBox, String keysToSend){
        if(inputBox.isDisplayed()){
            inputBox.clear();
            inputBox.sendKeys(keysToSend);
            return true;
        }else{
            return false;
        }
    }


    public static boolean navigate(WebDriver driver, String Url){
        boolean status;
        status= driver.getCurrentUrl().equals(Url);
        if(!status){
            driver.get(Url);
        }else{
            return status;
        }
        return status;
    }


    public static WebElement findElementWithRetry(WebDriver driver, By by, int retryCount ){
        WebElement elemnt = null;
        for(int i=0;i<retryCount;i++){
            elemnt= driver.findElement(by);
        }
        return elemnt;
    }


    

}
