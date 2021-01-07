package com.demo.TetsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.LaunchBrowser;
import com.demo.HelperClasses.FluentWaitHelper;

public class HomePage extends LaunchBrowser {
	
	private WebDriverWait waiter = null;
	@Test
	public void getHomePage() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.get("https://academybugs.com/find-bugs/#");
		driver.findElement(By.xpath("//div[@class='ec_product_page_sort']/span/a[1]")).click();
		FluentWaitHelper fw = new FluentWaitHelper();
		waiter = fw.getWebDriverWait(driver, 30);
		waiter.until(ExpectedConditions.visibilityOfElementLocated(fw.msgElement));
		Assert.assertNotNull(getElement(fw.msgElement), "There is an Error message on Page...");
	}

	

}
