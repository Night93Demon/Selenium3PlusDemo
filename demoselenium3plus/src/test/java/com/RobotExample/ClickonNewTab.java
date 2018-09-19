package com.RobotExample;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Drivers.Drivers;
import com.sun.glass.events.KeyEvent;

public class ClickonNewTab {

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
	public void testcase() throws AWTException, InterruptedException {
		driver.navigate().to("http://localhost:8083/TestMeApp/login.htm");
		
		Actions mouse=new Actions(driver);
		WebElement fp=driver.findElement(By.id("sam"));
		mouse.moveToElement(fp).contextClick().perform();
		
		Robot win=new Robot();
		Thread.sleep(2000);
		win.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		win.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		
		win.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
