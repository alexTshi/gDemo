package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	//creates objects using By class and assigns respective HTML web elements 
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector(".text-center>h2");
	private By navBar = By.cssSelector(".navbar.navbar-default.navbar-static-top");
	
	//assigns current driver instance the parameter driver object
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	//attempts to sign in using data provided and will be handled by loginPage class
	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage lgPage = new LoginPage(driver);
		return lgPage;
	}
	// returns title web element
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	//returns navigation bar web element
	public WebElement getNavigationBar() {
		return driver.findElement(navBar);
	}
}
