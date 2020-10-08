package Academy.E2EProject;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class validateNavigationBar extends Base{
	//Test will run first which eill initialize the drive object via method call and then it 
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		//retrieves value of url from propety file and navigates to page
		driver.get(prop.getProperty("url"));
	}	
	@Test
	public void validateNavBar() throws IOException{
		//navigates to the navigation bar on to validate is the bar is being displayed
		LandingPage lPage = new LandingPage(driver);	
		Assert.assertTrue(lPage.getNavigationBar().isDisplayed());
	}	
	//closes browser and instance after all tests scripts are run
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}