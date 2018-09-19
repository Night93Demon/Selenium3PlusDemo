package com.ActionsExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;

public class MouseOverExample {
	
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
		driver.get("http://www.drikpanchang.com");
		
		WebElement panchang=driver.findElement(By.xpath("//*[@id=\"dpMenuId\"]/li[3]/a"));
		
		Actions mouse=new Actions(driver);
		
		mouse.moveToElement(panchang);
		
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"dpMenuId\"]/li[3]/div[2]/div[2]/a[4]")).click();
		Thread.sleep(2000);
	}
	
	
	
	
	
	

}
