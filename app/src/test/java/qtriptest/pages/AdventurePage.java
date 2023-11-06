
package qtriptest.pages;

import qtriptest.SeleniumWrapper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class AdventurePage {
    RemoteWebDriver driver;

    @FindBy(id = "duration-select")
    WebElement select_hours;

    @FindBy(xpath = "//div[contains(text(),'Clear')][1]")
    WebElement clear_hours;

    @FindBy(id = "category-select")
    WebElement Select_category;

    @FindBy(xpath = "(//div[contains(text(),'Clear')])[2]")
    WebElement clear_Category;

    @FindBy(id = "search-adventures")
    WebElement search_adventure;

    @FindBy(xpath = "(//div[contains(text(),'Clear')])[3]")
    WebElement clear_Adventure;

    @FindBy(xpath = "//*[@id='data']/div[1]")
    WebElement select_Adventure;

    @FindBy(xpath = "//input[@id='search-adventures']")
    List<WebElement> numberOfAdventure;

    String Url = "https://qtripdynamic-qa-frontend.vercel.app/pages/adventures/?city=paris";

    public AdventurePage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
        // PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

    }

    public void navigatetoAdventurePage() {
        if (!driver.getCurrentUrl().equals(this.Url)) {
            driver.get(this.Url);
        }
    }

    public void SetFilterValue() {
        Select select1 = new Select(select_hours);
        select1.selectByIndex(3);
    }

    public boolean getResultCount(String filteredResult) throws InterruptedException {
        
        SeleniumWrapper.click(clear_hours, driver);
        SeleniumWrapper.click(clear_Category, driver);
        // clear_hours.click();
        // clear_Category.click();
        Integer actualResult = numberOfAdventure.size();
        String result = actualResult.toString();
        return result.equals(filteredResult);
    }

    public void setCategoryValue() {
        Select select2 = new Select(Select_category);
        select2.selectByIndex(3);
    }

    public void ClearFilterValue() throws InterruptedException {
        SeleniumWrapper.click(clear_Adventure, driver);
        //clear_Adventure.click();
    }

    public void searchAdventure(String AdventureName) throws InterruptedException {

        Thread.sleep(3000);
        SeleniumWrapper.sendKeys(search_adventure, AdventureName);
        //search_adventure.sendKeys(AdventureName);

    }

    public void SelectAdventure() throws InterruptedException {

        SeleniumWrapper.click(select_Adventure, driver);
       // select_Adventure.click();
    }
}



























