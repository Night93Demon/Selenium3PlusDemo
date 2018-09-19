package com.ActionsExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;

public class KeyEventsWithActionClass {
	
	WebDriver driver;
	String browser="chrome";
	@BeforeMethod
	public void openbrowser() {
		
		driver=Drivers.getdriver(browser);
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}
	@Test
	public void testcase() throws InterruptedException {
		
		driver.get("http://localhost:8083/TestMeApp/login.htm");
		
		Actions mouse=new Actions(driver);
		WebElement uname=driver.findElement(By.name("userName"));
		
		mouse.moveToElement(uname).click().keyDown(uname,Keys.SHIFT).perform();;
		Thread.sleep(2000);
		mouse.sendKeys(uname,"sumit").perform();;
		Thread.sleep(2000);
		mouse.keyUp(uname,Keys.SHIFT).perform();;
		Thread.sleep(2000);
		mouse.doubleClick().perform();;
		Thread.sleep(2000);
		mouse.contextClick(uname).perform();
		
		
		Thread.sleep(2000);
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
