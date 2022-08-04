package org.tyss.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationForAllure implements ITestListener{


	@Override
	public void onTestStart(ITestResult result) {

		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		byte[] path = ThreadSafeClass.getWebdriverutility().takeScreenShotPageInBytes(ThreadSafeClass.getDriver());
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	@Override //@Before test
	public void onStart(ITestContext context) {

		
	}

	@Override
	public void onFinish(ITestContext context) {

		
	}



	

}
