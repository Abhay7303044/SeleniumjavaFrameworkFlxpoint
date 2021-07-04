package singh.abbey;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReportNG;

public class Listeners extends Base implements ITestListener{
	
	
	ExtentReports extent= ExtentReportNG.getReportsObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	

	@Override
	public void onTestStart(ITestResult result) {
	
	 test= extent.createTest(result.getMethod().getMethodName());
	 extentTest.set(test);
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
	extentTest.get().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.get().fail(result.getThrowable());
		
	WebDriver driver = null;	
	String testmethodname=result.getMethod().getMethodName();
	
try {
	driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
} 
catch(Exception e) {
	
}
	try {
		extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testmethodname,driver), result.getMethod().getMethodName());
	
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}	
			
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
 extent.flush();		
	}

	
	
	
	
	
}
