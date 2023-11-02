
package qtriptest.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HistoryPage {
    RemoteWebDriver driver;
    String url = "https://qtripdynamic-qa-frontend.vercel.app/pages/adventures/reservations/";



    // @FindBy(xpath = "//td//preceding-sibling::th")
    // WebElement transaction_id_num;

    // @FindBy(xpath = "//*[@class='cancel-button']")
    // WebElement cancel_Button;

    @FindBy(xpath = "//td//preceding-sibling::th")
    List<WebElement> transactionId;

    @FindBy(xpath = "//button[text()='Cancel']")
    WebElement cancel_button;

    @FindBy(xpath="//*[@id='no-reservation-banner']")
    WebElement no_reservation_banner;

    @FindBy(xpath = "//div[contains(text(),'Logout')]")
    WebElement LogOutBtn;

    @FindBy (xpath ="//a[contains(text(),'Reservations')]")
    WebElement reservations;


    public HistoryPage(RemoteWebDriver driver) {
    //     this.driver = driver;
    //   //  PageFactory.initElements(this.driver, this);
    //   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    //   PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);

    this.driver= driver;
        PageFactory.initElements(this.driver, driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);

    }

    public void navigateToHistoryPage() throws InterruptedException {
        if (!driver.getCurrentUrl().equals(url)) {
            driver.get(url);
        }
    }

    public void storeTransactionId() {
        try {
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            Thread.sleep(1000);
            for (int i = 0; i < transactionId.size(); i++) {
                System.out.println("Transaction id: " + transactionId.get(i).getText());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean cancelReservations() throws InterruptedException {
        //Thread.sleep(3000);
        cancel_button.click();
        Thread.sleep(2000);
       // 
        
        if (transactionId.isEmpty()) {
            return true; // If the list is empty, the transaction ID is removed.
        } else {
            return false; // If the list is not empty, the transaction ID is still present.
        }
       
        
    }



    public boolean verifyCancelReservation() {
        if (no_reservation_banner.getText().contains("Oops! You have not made any reservations yet!")) {
            return true;
        } else {
            return false;
        }
    }

    public void logout() throws InterruptedException {
        Thread.sleep(2000);
        LogOutBtn.click();
    }

    public void reservationClick(){
        reservations.click();
    }


}
































