package org.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.ListenerImplementation;
import org.tyss.genericUtility.ThreadSafeClass;
import org.tyss.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(org.tyss.genericUtility.ListenerImplementation.class)
public class ExtentReportPractice {
	
	@Test
	public void extentReportPractice() throws InterruptedException {
		WebDriverUtility webdriver = new WebDriverUtility();
		ThreadSafeClass.setWebdriverutility(webdriver);
		ThreadSafeClass.setJavautility(new JavaUtility());
		
		
		WebDriverManager.chromedriver().setup();
		ListenerImplementation.testlog.info("Browser executable files intiallized");
	    WebDriver driver = new ChromeDriver();
	    ThreadSafeClass.setDriver(driver);
	    
		ListenerImplementation.testlog.info("Browser launched successfully");
	    driver.manage().window().maximize();
		ListenerImplementation.testlog.info("Browser maximized successfully");
	    driver.get("https://www.google.com/");
	    Assert.fail();
		ListenerImplementation.testlog.info("Application opened successfully");
	    driver.findElement(By.name("q")).sendKeys("cute baby photos",Keys.ENTER);
		ListenerImplementation.testlog.info("Baby photos searched successfully");
	    Thread.sleep(2000);
		ListenerImplementation.testlog.info("Application wait 2 sec");
	    driver.quit();
		ListenerImplementation.testlog.info("Browser closed successfully");
	    
	}

}
