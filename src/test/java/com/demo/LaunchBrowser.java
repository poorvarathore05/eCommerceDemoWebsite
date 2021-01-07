package com.demo;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	protected static WebDriver driver = null;
	
	@BeforeSuite
	public void startDriver(){
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://academybugs.com/find-bugs/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	public static WebElement getElement(By locator){
		if(driver.findElements(locator).size()==1){
			return driver.findElement(locator);
		}else
			throw new NoSuchElementException();
	}
	
	@AfterSuite
	public void teardowm(){
		if(driver != null){
			driver.close();
			driver.quit();
		}
	}
	
}
