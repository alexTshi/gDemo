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
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserType = prop.getProperty("browser");
		//System.out.println(browserType);
		//.equals evaluates to the comparison of values in the object
		//whereas == points to the same reference object aka a reference comparison
		//only has to be used when retrieving data from a property file
		if(browserType.equals("Chrome")) {
			//Hardcoded system property for 
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win33\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			//Chrom options can be passed to chromedriver
			driver = new ChromeDriver(options);
		}
		else if(browserType.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserType.equals("IE")) {
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public String getScreenShot(String methodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+methodName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
}
