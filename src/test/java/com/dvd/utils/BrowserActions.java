package com.dvd.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class BrowserActions {

	private static WebDriverWait waits;
	private static WebDriver driver;
	
	public static void setDriver(WebDriver driver) {
		BrowserActions.driver = driver;
	}
	public static void setExplicitwait(WebDriverWait explicitWait) {
		BrowserActions.waits = explicitWait;
	}
	public static void clickElementByXpath(String elementXpath) {
		WebElement elementByXpath = waits.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(elementXpath))));
		elementByXpath.click();
	}	
	public static void clickElementByCSS(String elementCSS) {
		WebElement elementByCSS = waits.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(elementCSS))));
		elementByCSS.click();
	}
	public static void keyboardKeysToElementByID(String elementID, Keys key) {
		WebElement elementByID = waits.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(elementID))));
		elementByID.sendKeys(key);
	}
	public static void sendKeysToElementByXpath(String elementXpath, String keys) {
		WebElement elementByXpath = waits.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elementXpath))));
		elementByXpath.sendKeys(keys);
	}
	public static String getTextOfElementByCSS(String elementCSS) {
		WebElement elemetInPage = waits.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(elementCSS))));
		return elemetInPage.getText();
	}
	public static void executeJS(String script) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript(script);
		
	}

}
