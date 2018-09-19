package com.Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;

public class WorkingWithLinks {
	
	WebDriver driver;
	String browser="chrome";
	@BeforeMethod
	public void openbrowser() {
		
		driver=Drivers.getdriver(browser);
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.flipkart.com");
		
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
	
	@Test
	public void testcase() {
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		System.out.println("The no. of links are "+links.size());
		
		for(int i=0;i<links.size();i++) {
			//System.out.println(links.get(i).getText());
			if(!links.get(i).getText().equals("")) {
				System.out.println(links.get(i).getText());
			}
		}
		
		
		
		
		
		
		
		
	}

}
