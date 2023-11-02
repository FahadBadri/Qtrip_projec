package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HomePage;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testCase_02 {
    static RemoteWebDriver driver;

    //public static lastGeneratedUsername= "";

    //Method to help us log out Unit Test

    public static  void logStatus(String type, String message, String status){
        System.out.println(String.format("%s   |   %s   |  %s  |  %s", 
        String.valueOf(java.time.LocalDateTime.now()), type, message, status));
    }

    //initialize webdriver for our unit Test
    @BeforeSuite(alwaysRun = true, enabled = true)
	public static void createDriver() throws MalformedURLException {
		logStatus("driver", "Initializing driver", "Started");
		// final DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setBrowserName(BrowserType.CHROME);
		//driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
		driver = DriverSingleton.getDriverInstance("chrome");
        logStatus("driver", "Initializing driver", "Success");
	}

   

    @Test(dataProvider = "DatasetsforQTrip", dataProviderClass =DP.class, enabled = true,
     description = "verify Search and Filter flow" , priority = 2, groups={"Search and Filter flow"})
   
  

public static void TestCase02( String CityName, String CategoryFilter, String DurationFilter,
String ExpectedFilteredResults, String ExpectedUnFilteredResults) throws InterruptedException{

 
            driver.manage().window().maximize();
            Thread.sleep(5000);

            HomePage home = new HomePage(driver);
            home.navigatetoHomePage();

            //Thread.sleep(2000);
            
            home.searchCity(CityName);
            Assert.assertFalse(home.verifyCityNotFound()," No Match found is Displayed");
           
            home.searchCity(CityName);

           Thread.sleep(5000);
           
           
           
            Assert.assertTrue(home.AssertAutoCompleteText(), "Suggestion city not  Found");
            home.SelectCity();

            AdventurePage adventurePage = new AdventurePage(driver);
            adventurePage.navigatetoAdventurePage();
           
            adventurePage.SetFilterValue();
            adventurePage.setCategoryValue();
            adventurePage.getResultCount("Nia");




            
       
       
        }
    }

    // package qtriptest.tests;

    // import qtriptest.DP;
    // import qtriptest.DriverSingleton;
    // import qtriptest.pages.AdventurePage;
    // import qtriptest.pages.HomePage;
    // import java.net.MalformedURLException;
    // import java.net.URL;
    // import org.apache.logging.log4j.core.util.Assert;
    // import org.openqa.selenium.remote.BrowserType;
    // import org.openqa.selenium.remote.DesiredCapabilities;
    // import org.openqa.selenium.remote.RemoteWebDriver;
    // import org.testng.annotations.AfterSuite;
    // import org.testng.annotations.BeforeSuite;
    // import org.testng.annotations.Test;
    
    // public class testCase_02 {
    
    //     static RemoteWebDriver driver;
    //     //public static String lastGeneratedUsername;
    
    //      // Method to help us log our Unit Tests
    //      public static void logStatus(String type, String message, String status) {
    //         System.out.println(String.format("%s |  %s  |  %s | %s",
    //                 String.valueOf(java.time.LocalDateTime.now()), type, message, status));
    //     }
    
    //     // Iinitialize webdriver for our Unit Tests
    //     @BeforeSuite(alwaysRun = true, enabled = true)
    //     public static void createDriver() throws MalformedURLException {
    //         logStatus("driver", "Initializing driver", "Started");
    //         // final DesiredCapabilities capabilities = new DesiredCapabilities();
    //         // capabilities.setBrowserName(BrowserType.CHROME);
    //         // driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
    //     driver=DriverSingleton.getDriverInstance("chrome");
    //         logStatus("driver", "Initializing driver", "Success");
       
    //       }
    
    //       @Test(enabled = true, description = "Search and Filter flow" , priority = 2,dataProvider = "DatasetsforQTrip", dataProviderClass = DP.class,groups={"Search and Filter flow"})
          
    //       public static void testCase_02( String CityName, String CategoryFilter, String DurationFilter,
    //       String ExpectedFilteredResults, String ExpectedUnFilteredResults) throws InterruptedException{
            
    //         driver.manage().window().maximize();
    //         Thread.sleep(5000);
    
    //         HomePage home = new HomePage(driver);
    //         home.navigatetoHomePage();
    
    //         home.searchCity(CityName);
    //         //assertTrue(home.cityNotFound(), "No city found is not displayed ");
    //         home.verifyCityNotFound();
    
    //         home.searchCity(CityName);
            
    //         //assertTrue(home.AssertAutoCompleteText(), "City suggestion is not displayed");
    //         home.AssertAutoCompleteText();
            
    //         home.SelectCity();
    
    //         AdventurePage adventurepage = new AdventurePage(driver);
    //         adventurepage.navigatetoAdventurePage();
    
    //         adventurepage.SetFilterValue(CategoryFilter);
    //         adventurepage.SetCategoryValue(ExpectedFilteredResults);
    //         adventurepage.getResultCount(ExpectedUnFilteredResults);
    
    //       }
    
    
    //     @AfterSuite
    //     public static void quitDriver() {
    //     System.out.println("quit()");
    //     driver.quit();
    //     }
    // }


    