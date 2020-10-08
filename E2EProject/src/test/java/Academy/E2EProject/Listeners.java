package Academy.E2EProject;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Academy.E2EProject.Base;
import Resources.ExtentReportNG;

//listeners object class
public class Listeners extends Base implements ITestListener{
	//initialize an ExtentReports object
	ExtentReports extent = ExtentReportNG.getReportObject();
	ExtentTest test;

	//ExtentTest object belongs to Threadlocal which will give the correct thread for each object ran parallel
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		//must set thread to be mapped correctly
		extentTest.set(test);
	}
	//with a successful test. the report should be add to the log as "Passed test"
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		
	}
	//with a failure in test
	public void onTestFailure(ITestResult result) {
		// implement screenshot method
		WebDriver driver = null;
		String testName = result.getMethod().getMethodName();
		//below methods captures the instance of the driver object which will be send to the class in Base
		//following line will check thread pool to give validatetitle get method
		extentTest.get().fail(result.getThrowable());
		try {
			//retrives driver instance of failed test
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e) {			
			e.printStackTrace();
		} 	
		try {
			//adds screenshot with the path and file details of methodname which failed
			extentTest.get().addScreenCaptureFromPath(getScreenShot(testName,driver),result.getMethod().getMethodName());			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
