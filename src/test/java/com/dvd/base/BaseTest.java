package com.dvd.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.dvd.test_autom.IDriverManager;
import com.dvd.utils.BrowserActions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IDriverManager{

	static WebDriver driver;
	static WebDriverWait waits;
	
	
	@BeforeMethod
	public void befTest() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		waits = new WebDriverWait(driver, Duration.ofMinutes(1));
		
		BrowserActions.setDriver(driver);
		BrowserActions.setExplicitwait(waits);
		
		driver.get("https://staging.engineer.ai/home");
	}
	
	@AfterMethod(alwaysRun = true)
	public void aftest(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			File getSS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(getSS, new File(System.getProperty("user dir")+File.separator+result.getName()+".png"));
			
		}
	
		//driver.quit();
	}
}
