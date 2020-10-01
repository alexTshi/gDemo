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
	//When running parallel, you may run through some failure issues so it's better to add a local 
	//Webdriver so that there are no conflicts when ran on
	public WebDriver driver;
	//must have before very test case when using log4j
	private static Logger Log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		Log.debug("Driver Initialized");
		driver.get(prop.getProperty("url"));
		Log.debug("Url Activated");
	}
	
	@Test
	public void getTitle() throws IOException{
		LandingPage lPage = new LandingPage(driver);
		Assert.assertEquals(lPage.getTitle().getText(), "FEATURED COURrSES");	
		Log.debug("Successfully Validated Title");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}