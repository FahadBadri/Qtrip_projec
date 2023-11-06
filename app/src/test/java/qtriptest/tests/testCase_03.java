package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.ReportSingleton;
import qtriptest.pages.AdventureDetailsPage;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HistoryPage;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import java.net.MalformedURLException;
//import java.net.URL;
import qtriptest.pages.RegisterPage;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testCase_03 {

   static RemoteWebDriver driver;
   public String lastGeneratedUsername="";

  //Method to help us log out Unit Test

  public static  void logStatus(String type, String message, String status){
    System.out.println(String.format("%s   |   %s   |  %s  |  %s", 
    String.valueOf(java.time.LocalDateTime.now()), type, message, status));
}

//initialize webdriver for our unit Test
@BeforeSuite(alwaysRun = true, enabled = true)
public static void createDriver() throws MalformedURLException {
    logStatus("driver", "Initializing driver", "Started");
    driver = DriverSingleton.getDriverInstance("chrome");
    logStatus("driver", "Initializing driver", "Success");
}



@Test(dataProvider = "DatasetsforQTrip", dataProviderClass =DP.class, enabled = true,
description = "verify Booking and Cancellation Flow" , priority = 3, groups={"Booking and Cancellation Flow"})

        public static void TestCase03(String NewUserName,String Password, String SearchCity,
        String AdventureName,String GuestName,String Date,String count ) throws InterruptedException{

            	
		driver.manage().window().maximize();
		Thread.sleep(5000);

        ReportSingleton.test=ReportSingleton.report.startTest("Booking and Cancellation Flow");
		HomePage home= new HomePage(driver);
		home.navigatetoHomePage();

        RegisterPage register = new RegisterPage(driver);
       
        register.navigateToRegistrationPage();
        register.RegisterNewUser( NewUserName , Password, true);
        String lastUsername = register.lastgeneratedUsername;
       
       
        LoginPage login= new LoginPage(driver);   
        Thread.sleep(2000);     
		login.performLogin(lastUsername, Password);
		//Assert.assertTrue(login.verifyLogin());
		
        home.searchCity(SearchCity);
    
        Thread.sleep(5000);
        
        
        
         Assert.assertTrue(home.AssertAutoCompleteText(), "Suggestion city not  Found");
         home.SelectCity();

         AdventurePage adventurePage = new AdventurePage(driver);
         adventurePage.searchAdventure(AdventureName);
         adventurePage.SelectAdventure();

         AdventureDetailsPage adventurePagedetails = new AdventureDetailsPage(driver);

         adventurePagedetails.bookAdventure(GuestName, Date, count);
         adventurePagedetails.isBookingSuccesful();
        
         
         adventurePagedetails.clickonHistoryPage();

        
       
        
        HistoryPage history= new HistoryPage(driver);
        history.storeTransactionId();
        history.cancelReservations();
        driver.navigate().refresh();
        history.verifyCancelReservation();
       history.logout();


        }

}




