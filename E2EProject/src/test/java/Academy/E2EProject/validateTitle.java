package Academy.E2EProject;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class validateTitle extends Base{
	//Adding local Web driver so that there are no conflicts when ran on parallel
	public WebDriver driver;
	private static Logger Log = LogManager.getLogger(Base.class.getName());
	
	//test run before all tests in c	lass
	@BeforeTest
	public void initialize() throws IOException {
		//method will initialize driver from base class and add "Debug" type level logs
		driver = initializeDriver();
		Log.info("Driver Initialized");
		driver.get(prop.getProperty("url"));
		Log.info("Url Activated");
	}	
	@Test
	public void getTitle() throws IOException{
		//method will call landing page to validate a title and add again to logger
		LandingPage lPage = new LandingPage(driver);
		//Test explicitly set to fail for check how errors will be handled
		Assert.assertEquals(lPage.getTitle().getText(), "FEATURED COURrSES");	
		Log.info("Successfully Validated Title");
	}
	//closes browser and instance after all tests scripts are run
	@AfterTest
	public void tearDown() {
		//closes driver instance
		driver.close();
	}
}