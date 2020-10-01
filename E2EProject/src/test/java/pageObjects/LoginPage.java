package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	By login = By.cssSelector("[id='user_email']");
	By password = By.cssSelector("[type='password']");
	By submit = By.cssSelector("input[type='submit']");
	By forgotPass = By.cssSelector("[href*='password/new/']");

	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPass).click();
		return new ForgotPassword(driver);
	}
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(login);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement submit() {
		return driver.findElement(submit);
	}
}
