package org.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tyss.genericUtility.JavaUtility;
import org.tyss.genericUtility.ThreadSafeClass;
import org.tyss.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners(org.tyss.genericUtility.ListenerImplementationForAllure.class)
@Epic("epic 1")
@Story("story 1")
public class AllureReportPractice {
	@Description("Allure description 124")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void extentReportPractice() throws InterruptedException {
		WebDriverUtility webdriverUtility = new WebDriverUtility();
		ThreadSafeClass.setWebdriverutility(webdriverUtility);
		ThreadSafeClass.setJavautility(new JavaUtility());
		
		WebDriverManager.chromedriver().setup();
		printStatement("Browser executable files intiallized");
	    WebDriver driver = new ChromeDriver();
	    ThreadSafeClass.setDriver(driver);
	    
	    Allure.step("Browser launched successfully");
	    driver.manage().window().maximize();
	    Allure.step("Browser maximized successfully");
	    driver.get("https://www.google.com/");
	    Assert.fail();
	    Allure.step("Application opened successfully");
	    driver.findElement(By.name("q")).sendKeys("cute baby photos",Keys.ENTER);
	    Allure.step("Baby photos searched successfully");
	    Thread.sleep(2000);
	    Allure.step("Application wait 2 sec");
	    driver.quit();
	    Allure.step("Browser closed successfully");
	    
	}
	//this is the another method to do in allure inspect of allure.step
	@Step("{str}")
	public void printStatement(String str) {
		System.out.println(str);
	}

}
