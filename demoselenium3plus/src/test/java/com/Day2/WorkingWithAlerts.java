package com.Day2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;
import com.RobotExample.SnapShot;

public class WorkingWithAlerts {
	
	WebDriver driver;
	String browser="chrome";
	@BeforeMethod
	public void openbrowser() {
		
		driver=Drivers.getdriver(browser);
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com");
		
	}
	
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
	@Test
	public void testcase() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//*[@id=\"get_sign_in\"]")).click();
		SnapShot.getscreenshot(driver, "C:\\Users\\s.wankhede\\Desktop\\Screenshots\\Test1.png");
		WebElement frameid=driver.findElement(By.id("authiframe"));
		driver.switchTo().frame(frameid);
		driver.findElement(By.id("authMobile")).sendKeys("8826759987");
		SnapShot.getscreenshot(driver, "C:\\Users\\s.wankhede\\Desktop\\Screenshots\\Test2.png");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"authOverlay\"]/div/a")).click();
		SnapShot.getscreenshot(driver, "C:\\Users\\s.wankhede\\Desktop\\Screenshots\\Test3.png");
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	
	

}
