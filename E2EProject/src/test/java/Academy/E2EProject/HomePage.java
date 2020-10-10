/**********************
 * By: Mulumba Tshiswaka
 * Date: October 1st, 2020
 * Description:
 * This Project will test the functionality of the web page "http://www.qaclickacademy.com/"
 * using the Selenium Framework, and Maven plus TestNG build tools. Core concepts of Java will be utilized
 * to ensure that the project is efficiently written. TestNG Annotations will be used to control 
 * sequence of executions. Through the projects Texts, User Names, Passwords will be tested. 
 * Outcomes are simulated based on certain criterias.
 * 
 *********************/

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
	//script to execute before others
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}
	
	//following script will utilize data provided from @DataProvider annotation
	@Test(dataProvider = "getData")
	public void validateLogin(String username, String password, String valid) throws IOException{
		//following scripts will run multiple times according to data provided
		//it will first validate title of a page label
		//it will second check login credentials which are incorrect
		//it will thirdly select the forgot button option to allow for retrieval of credentials 
		driver.get(prop.getProperty("url"));
		LandingPage lPage = new LandingPage(driver);
		LoginPage lgPage = lPage.getLogin();
		lgPage.getEmail().sendKeys(username);
		lgPage.getPassword().sendKeys(password);
		lgPage.submit().click();
		//
		ForgotPassword fp = lgPage.forgotPassword();
		fp.getEmail().sendKeys("testing");
		fp.sendInstructions().click();
	}
	
	//Data provided to allow pages to be tested 
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
		//closes driver instance
		driver.close();
	}
}
