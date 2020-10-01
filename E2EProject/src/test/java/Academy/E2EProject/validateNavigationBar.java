package Academy.E2EProject;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class validateNavigationBar extends Base{
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateNavBar() throws IOException{
		LandingPage lPage = new LandingPage(driver);	
		Assert.assertTrue(lPage.getNavigationBar().isDisplayed());
	}	
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}