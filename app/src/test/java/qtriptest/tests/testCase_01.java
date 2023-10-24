package qtriptest.tests;

import java.net.MalformedURLException;
import java.net.URL;
import qtriptest.DP;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
//import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;


public class testCase_01 {
    static RemoteWebDriver driver;
    public String lastGeneratedUsername="";

 	// Method to help us log our Unit Tests
     public static void logStatus(String type, String message, String status) {
		System.out.println(String.format("%s |  %s  |  %s | %s",
				String.valueOf(java.time.LocalDateTime.now()), type, message, status));
	}

	// Iinitialize webdriver for our Unit Tests
	@BeforeSuite(alwaysRun = true, enabled = true)
	public static void createDriver() throws MalformedURLException {
		logStatus("driver", "Initializing driver", "Started");
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
		logStatus("driver", "Initializing driver", "Success");
	}

    @Test(dataProvider = "DatasetsforQTrip", dataProviderClass =DP.class, enabled = true, description = "verify Login flow" , priority = 1, groups={"Login Flow"})
     public  void TestCase01(String Username, String password) throws InterruptedException{
		
		driver.manage().window().maximize();
		Thread.sleep(5000);


		HomePage home= new HomePage(driver);
		home.navigatetoHomePage();

		RegisterPage register= new RegisterPage(driver);
        register.navigateToRegistrationPage();
        register.RegisterNewUser(Username, password, true);
		String lastUsername = register.lastgeneratedUsername;
        System.out.println("registration complete "+"username");

		LoginPage login= new LoginPage(driver);
		login.performLogin(lastUsername, password);
		Assert.assertTrue(login.verifyLogin());
		login.logout();
		Assert.assertTrue(login.verifyLogOut());


	}
     

}
