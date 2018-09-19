package com.ExtentReportExample;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DemoExtentReports {

	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	public void startTest() {
		extent=new ExtentReports("C:\\Users\\s.wankhede\\Desktop\\ExtentReports\\reports.html", true);
		extent.addSystemInfo("HostName", "Accenture")
		.addSystemInfo("Environment","Automation Testing")
		.addSystemInfo("UserName","s.wankhede");
		
		extent.loadConfig(new File("C:\\Git Projects\\demoselenium3plus\\src\\test\\java\\com\\ExtentReportExample\\ExtentConfig.xml"));
		
	}
	
	@Test
	public void positivetest() {
		logger=extent.startTest("ptest");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS	, "Test case passed ");
		
		
	}
	@Test
	public void negativetest() {
		logger=extent.startTest("negativetest");
		Assert.assertFalse(false);
		logger.log(LogStatus.FAIL	, "Test case failed");
	}
	
	@AfterMethod
	public void resultmethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
		logger.log(LogStatus.FAIL, "TestCase Failed is "+result.getName());
		logger.log(LogStatus.FAIL, "TestCase Failed is "+result.getThrowable());
		
	}else if(result.getStatus()==ITestResult.SUCCESS) {
		logger.log(LogStatus.PASS	, "TestCase passed is "+result.getName());
	}
		extent.endTest(logger);
	
	
	}	
	@AfterTest
	public void closebrowser() {
		extent.flush();
		extent.close();
	}
	
}
