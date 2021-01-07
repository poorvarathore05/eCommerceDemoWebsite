package com.demo.TetsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.LaunchBrowser;
import com.demo.HelperClasses.FluentWaitHelper;
import com.demo.HelperClasses.SelectOption;

public class ChangeCurrency extends LaunchBrowser {

	@Test
	public void selectCurrency() {

		driver.manage().deleteAllCookies();
		driver.get("https://academybugs.com/find-bugs/#");
		driver.findElement(By.id("ec_add_to_cart_2")).click();
		FluentWaitHelper fw = new FluentWaitHelper();
		WebDriverWait waiter = fw.getWebDriverWait(driver, 30);
		waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("ec_added_to_cart_2"))).click();
		fw.waitForLoadingMask(driver, 30);
		Select sel = new Select(driver.findElement(By.id("ec_currency_conversion")));
		SelectOption.selectByValue(By.id("ec_currency_conversion"), "EUR");
		waiter = fw.getWebDriverWait(driver, 30);
		waiter.until(ExpectedConditions.visibilityOfElementLocated(fw.msgElement));
		Assert.assertNotNull(getElement(fw.msgElement), "There is an Error message on Page...");
	}
}
