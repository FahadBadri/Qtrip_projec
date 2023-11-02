package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.pages.AdventureDetailsPage;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HistoryPage;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
//import java.net.URL;
import qtriptest.pages.RegisterPage;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testCase_04 {

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
description = " Booking History Flow" , priority = 4, groups={"Booking and Cancellation Flow"})

        
public static void TestCase04(String NewUserName,String Password, String dataset1,String dataset2,String dataset3)
 throws InterruptedException, MalformedURLException{

    driver.manage().window().maximize();
    Thread.sleep(5000);

    HomePage home= new HomePage(driver);
		home.navigatetoHomePage();
        

        RegisterPage register = new RegisterPage(driver);
       
        register.navigateToRegistrationPage();
        register.RegisterNewUser( NewUserName , Password, true);
        String lastUsername = register.lastgeneratedUsername;
        LoginPage login= new LoginPage(driver);
        
		login.performLogin(lastUsername, Password);
		//Assert.assertTrue(login.verifyLogin());

    String[] data1 =  dataset1.split(";");
    String[] data2 =  dataset2.split(";");
    String[] data3 =  dataset3.split(";");

    ArrayList<String[]> list = new ArrayList<>();

    list.add(data1);
    list.add(data2);
    list.add(data3);

    for(String[] data : list){


            Thread.sleep(4000);
            home.searchCity(data[0]);
        
            Thread.sleep(4000);
            home.SelectCity();

            AdventurePage adventurePage = new AdventurePage(driver);
            Thread.sleep(2000);
            adventurePage.searchAdventure(data[1]);
            Thread.sleep(2000);
            adventurePage.SelectAdventure();

            AdventureDetailsPage adventureDetails= new AdventureDetailsPage(driver);
            adventureDetails.bookAdventure(data[2], data[3], data[4]);
            adventureDetails.isBookingSuccesful();

            home.navigatetoHomePage();


    }

    HistoryPage history= new HistoryPage(driver);
    history.reservationClick();
    Thread.sleep(3000);
    history.storeTransactionId();
    Thread.sleep(3000);
   // home.LogoutUser();

}

// @AfterSuite
// public static void quitDriver() {
// System.out.println("quit()");
// driver.quit();
// }






// public static void TestCase04(String Username,String password, String dataset1,String dataset2, String dataset3) throws InterruptedException{



            	
		// driver.manage().window().maximize();
		// Thread.sleep(5000);


		// HomePage home= new HomePage(driver);
		// home.navigatetoHomePage();
        

        // RegisterPage register = new RegisterPage(driver);
       
        // register.navigateToRegistrationPage();
        // register.RegisterNewUser( Username , password, true);
        // String lastUsername = register.lastgeneratedUsername;
        // LoginPage login= new LoginPage(driver);
        
		// login.performLogin(lastUsername, password);
		// //Assert.assertTrue(login.verifyLogin());
		
        // String[] data1 = dataset1.split(";");
        // String[] data2 = dataset2.split(";");
        // String[] data3 = dataset3.split(";");

        // List<String[]> list = new ArrayList<>();
        // list.add(data1);
        // list.add(data2);
        // list.add(data3);

        // for(String[] data :list){

        
        
    //     home.searchCity(data1[0]);
       
    //     Thread.sleep(2000);
       
    //      //Assert.assertTrue(home.AssertAutoCompleteText(), "Suggestion city not  Found");
    //      home.SelectCity();

    //      AdventurePage adventurePage = new AdventurePage(driver);
    //      adventurePage.searchAdventure(data1[1]);
    //      adventurePage.SelectAdventure();

    //      AdventureDetailsPage adventurePagedetails = new AdventureDetailsPage(driver);

    //      adventurePagedetails.bookAdventure(data1[2], data1[3], data1[4]);
    //      adventurePagedetails.isBookingSuccesful();
    //      //adventurePagedetails.clickonHistoryPage();



                 
    //     Thread.sleep(5000);
    //     home.navigatetoHomePage();

    //     home.searchCity(data2[0]);
       
    //     Thread.sleep(2000);
      
    //      //Assert.assertTrue(home.AssertAutoCompleteText(), "Suggestion city not  Found");
    //      home.SelectCity();

    //      AdventurePage adventurePage1 = new AdventurePage(driver);
    //      adventurePage1.searchAdventure(data2[1]);
    //      adventurePage1.SelectAdventure();

    //      AdventureDetailsPage adventurePagedetails1 = new AdventureDetailsPage(driver);

    //      adventurePagedetails1.bookAdventure(data2[2], data2[3], data2[4]);
    //      adventurePagedetails1.isBookingSuccesful();
    //      //adventurePagedetails.clickonHistoryPage();


  

    //      home.navigatetoHomePage();
    //      home.searchCity(data3[0]);
       
    //      Thread.sleep(2000);
    //      // Assert.assertTrue(home.AssertAutoCompleteText(), "Suggestion city not  Found");
    //       home.SelectCity();
 

 
    //      AdventurePage adventurePage2 = new AdventurePage(driver);
    //      adventurePage2.searchAdventure(data3[1]);
    //      adventurePage2.SelectAdventure();

    //      AdventureDetailsPage adventurePagedetails2 = new AdventureDetailsPage(driver);

    //      adventurePagedetails2.bookAdventure(data3[2], data3[3], data3[4]);
    //      adventurePagedetails2.isBookingSuccesful();
    //      //adventurePagedetails2.clickonHistoryPage();

         




    //     HistoryPage history= new HistoryPage(driver);
    //     history.reservationClick();
    //     history.storeTransactionId();
    //         // history.cancelReservations();
    //      //history.logout();
    //   //  }
        
        
    //     //HistoryPage history= new HistoryPage(driver);
    //     // history.storeTransactionId();
    //     //  history.cancelReservations();
    //      history.logout();


























        }


