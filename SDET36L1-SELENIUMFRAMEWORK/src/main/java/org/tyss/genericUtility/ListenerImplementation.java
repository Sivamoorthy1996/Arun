package org.tyss.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	int count =0;
	int maxRetrycount=3;
	private ExtentReports report;
	private ExtentTest test ;
	public static  ExtentTest testlog ;

	@Override
	public void onTestStart(ITestResult result) {
	 test = report.createTest(result.getMethod().getMethodName());
	 test.assignAuthor("siva");
	 test.assignCategory("sanity testing");
		  testlog = test;
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+" is pass");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	test.fail(result.getMethod().getMethodName()+"is failed");
		test.fail(result.getThrowable());
		
		
		String pathofScreenShot = ThreadSafeClass.getWebdriverutility().takeScreenShotPage(ThreadSafeClass.getDriver());
		test.addScreenCaptureFromBase64String(pathofScreenShot, result.getMethod().getMethodName());
		//test.addScreenCaptureFromBase64String(pathofScreenShot, "my 1 shot");//this thing for extent report
		
		
		//test.addScreenCaptureFromBase64String(pathofScreenShot);
    // ThreadSafeClass.getDriver1().TakesScreenShot(result.getMethod().getMethodName(), ThreadSafeClass.getDriver2());	(this thing for normal screenshot)	
	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.skip(result.getMethod().getMethodName()+" is skipped");
		test.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	@Override //@Before test
	public void onStart(ITestContext context) {
	    ExtentSparkReporter spark = new ExtentSparkReporter("./sivaextentreport-output/emailable-extentreport.html");
		spark.config().setDocumentTitle("Document Tiltle is sushma_siva");
		spark.config().setReportName("report name 1");
		spark.config().setTheme(Theme.STANDARD);
		 report = new ExtentReports();
		 report.attachReporter(spark);
		 report.setSystemInfo("os","Windows 10");
		 report.setSystemInfo("Browser Name", "Chrome");
		 report.setSystemInfo("Browser version","103.11.234");
		
	}

	@Override
	public void onFinish(ITestContext context) {
	report.flush();
		
	}

//	@Override
//	public boolean retry(ITestResult result) {
//		
//		while(count<maxRetrycount) {
//			count++;
//			return true;
//		}
//		
//		return false;
//	}

	

}
