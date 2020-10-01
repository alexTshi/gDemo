package Academy.E2EProject;
import java.io.IOException;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePage extends Base {
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}
	
	@Test(dataProvider = "getData")
	public void validateLogin(String username, String password, String valid) throws IOException{
		
		driver.get(prop.getProperty("url"));
		LandingPage lPage = new LandingPage(driver);
		LoginPage lgPage = lPage.getLogin();
		lgPage.getEmail().sendKeys(	username);
		lgPage.getPassword().sendKeys(password);
		
		lgPage.submit().click();
		ForgotPassword fp = lgPage.forgotPassword();
		fp.getEmail().sendKeys("testing");
		fp.sendInstructions().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		//1st Row
		data[0][0] = "jerryrice@gmail.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted user";
		//2nd row
		data[1][0] = "malcommiddle99@gmail.com";
		data[1][1] = "123456";
		data[1][2] = "Non Restricted user";
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
