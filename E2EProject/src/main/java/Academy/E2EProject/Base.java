package Academy.E2EProject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public Properties prop;
	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException {
		//initializing properties object
		prop = new Properties();
		//initializing FileInputStream associating to the properties files
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		//properties object is point to the file stream
		prop.load(fis);
		//browseType variable will be initialized with the value from browser variable within the properties file(fis)
		String browserType = prop.getProperty("browser");
		
		if(browserType.equals("Chrome")) {
			//Hardcoded System Property for Chromedriver Option
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win33\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			//Chrome options passed to chromedriver
			driver = new ChromeDriver(options);
		}
		else if(browserType.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserType.equals("IE")) {
			
		}
		//Will give a general wait of 10 seconds to the page.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public String getScreenShot(String methodName, WebDriver driver) throws IOException {
		//initializing TakeScreenshot interface object and typecasting the image of the Webdrive instance
		TakesScreenshot ts = (TakesScreenshot) driver;
		//creating a file source and calling method to take screenshot
		File source = ts.getScreenshotAs(OutputType.FILE);
		//destinationFile string object is filled with the root directory path, name of method and extention
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+methodName+".png";
		//creates a copy of the screenshot to a new file
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
}
