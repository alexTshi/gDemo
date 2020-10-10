package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//class will the web objects in order for validateTitle class to send password retrieval information
public class ForgotPassword {
	public WebDriver driver;
	
	//creates objects using By class and assigns respective HTML web elements 
	private By login = By.cssSelector("[id='user_email']");
	private By sendInstructions = By.cssSelector("input[type='submit']");

	//returns instance of WebDriver object
	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}	
	//returns email web element
	public WebElement getEmail() {
		return driver.findElement(login);
	}
	//returns button click web element
	public WebElement sendInstructions() {
		return driver.findElement(sendInstructions);
	}
}
