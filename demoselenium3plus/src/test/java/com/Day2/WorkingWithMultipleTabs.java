package com.Day2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;

public class WorkingWithMultipleTabs {
	
	WebDriver driver;
	String browser="chrome";
	@BeforeMethod
	public void openbrowser() {
		
		driver=Drivers.getdriver(browser);
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.naukri.com");
		
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
	
	@Test
	public void testcase() throws InterruptedException {
		Thread.sleep(2000);
		String mwid=driver.getWindowHandle();
		
		Set<String> allwinids=driver.getWindowHandles();
		
		for(String x:allwinids) {
			if(!x.equals(mwid)) {
				driver.switchTo().window(x);
				driver.close();
			}
		}
		
		
		driver.switchTo().window(mwid);
		
		Thread.sleep(3000);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
