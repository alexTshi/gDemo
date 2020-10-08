package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	//creates objects using By class and assignes respective html web elements 
	By login = By.cssSelector("[id='user_email']");
	By password = By.cssSelector("[type='password']");
	By submit = By.cssSelector("input[type='submit']");
	By forgotPass = By.cssSelector("[href*='password/new/']");

	//will click on forgot password and calls ForgotPassword class to handle test
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPass).click();
		return new ForgotPassword(driver);
	}
	//assigns current driver instance the parameter driver object
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	//returns web element 
	public WebElement getEmail() {
		return driver.findElement(login);
	}
	//returns web element 
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	//returns web element 
	public WebElement submit() {
		return driver.findElement(submit);
	}
}
