package qtriptest.pages;

import qtriptest.SeleniumWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;

public class AdventureDetailsPage {

    RemoteWebDriver driver;

    public AdventureDetailsPage(RemoteWebDriver driver) {
        this.driver = driver;
       
       PageFactory.initElements(driver, this);
    //    this.driver=driver;
    //     AjaxElementLocatorFactory ajax= new AjaxElementLocatorFactory(driver,  10);
    //     PageFactory.initElements(ajax, this);

    
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

    }


    @FindBy(xpath = "//*[@id='myForm']/input[1]")
    WebElement name_input_Bx;

    @FindBy(xpath = "//*[@id='myForm']/input[2]")
    WebElement date_input_Bx;

    @FindBy(xpath = "//*[@id='myForm']/div[1]/div[2]/input")
    WebElement person_count;

    @FindBy(xpath = "//*[@id='myForm']/button")
    WebElement reserve_button;

    @FindBy(id = "reserved-banner")
    WebElement greeting_text_alert;

    @FindBy(linkText = "here")
    WebElement click_here_link;

    public void bookAdventure(String name, String date, String Count) throws InterruptedException {
        Thread.sleep(2000);

       // name_input_Bx.clear();
        SeleniumWrapper.sendKeys(name_input_Bx, name);
       // name_input_Bx.sendKeys(name);

       SeleniumWrapper.sendKeys(date_input_Bx, date);
       // date_input_Bx.sendKeys(date);

        //person_count.clear();

        SeleniumWrapper.sendKeys(person_count, Count);
        //person_count.sendKeys(Count);

        SeleniumWrapper.click(reserve_button, driver);
        //reserve_button.click();


    }



    public boolean isBookingSuccesful() throws InterruptedException {

        Thread.sleep(2000);

        if (greeting_text_alert.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void clickonHistoryPage() throws InterruptedException {

       SeleniumWrapper.click(click_here_link, driver);
        //click_here_link.click();

    }



}













