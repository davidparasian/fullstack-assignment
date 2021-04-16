package com.dvd.test_autom;


import org.testng.annotations.Test;

import com.dvd.base.BaseTest;
import com.dvd.pages_autom.HomePage;
import com.dvd.pages_autom.LoginPage;
import com.dvd.pages_autom.MenuPage;
import com.dvd.utils.BrowserActions;


public class WebTest extends BaseTest {
	
	
	@Test
	public void loginTes() {
		String credential="jogidemo321@gmail.com";
		String credentials="builder123";
		
		
		BrowserActions.clickElementByXpath(HomePage.LoginButtonXpath);
		BrowserActions.clickElementByXpath(HomePage.LoginAlreadyXpath);
		
		BrowserActions.sendKeysToElementByXpath(LoginPage.emailXpath, credential);
		BrowserActions.sendKeysToElementByXpath(LoginPage.passwordXpath, credentials);
		BrowserActions.clickElementByXpath(LoginPage.submitXpath);
		
		BrowserActions.executeJS("MenuPage.mobileApp.click()");
		BrowserActions.clickElementByXpath(MenuPage.mobileApp);
		BrowserActions.clickElementByXpath(MenuPage.uberXpath);
		BrowserActions.clickElementByXpath(MenuPage.getStartXpath);
	
	}

}
