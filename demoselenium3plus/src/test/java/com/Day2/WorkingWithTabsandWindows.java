package com.Day2;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;

public class WorkingWithTabsandWindows {
	
	WebDriver driver;
	String browser="chrome";
	@BeforeMethod
	public void openbrowser() {
		
		driver=Drivers.getdriver(browser);
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.licindia.com");
		
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.quit();
	}
	
	@Test
	public void testcase() throws InterruptedException {
		//Clicking on fb icon
		driver.findElement(By.xpath("//*[@id=\"socialThings2\"]/ul/li[1]/a/img")).click();
		
		Set <String> s=driver.getWindowHandles();
		
		Iterator<String> it=s.iterator();
		
		String mwid=it.next();
		String t1=it.next();
		Thread.sleep(2000);
		driver.switchTo().window(t1);
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("SumitWankhede");
		Thread.sleep(2000);
		driver.switchTo().window(mwid);
		Thread.sleep(2000);
		driver.switchTo().window(t1);
		Thread.sleep(2000);
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
