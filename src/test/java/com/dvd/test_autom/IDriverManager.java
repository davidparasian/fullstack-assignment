package com.dvd.test_autom;

import java.io.IOException;

import org.testng.ITestResult;

public interface IDriverManager {
	
	public void befTest();
	public void aftest(ITestResult result) throws IOException;

}
