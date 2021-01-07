package com.demo.TetsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.LaunchBrowser;
import com.demo.HelperClasses.FluentWaitHelper;

public class EmptyCart extends LaunchBrowser {

	private String blueTshirt = "ec_add_to_cart_2";
	private String blueTshirtAdded = "ec_added_to_cart_2";
	private String deleteProd = "//main[@id='main']//div[3]/table[1]/tbody[1]/tr[3]/td[1]/div[1]";
	private String returnToStore = "//div[@class ='ec_cart_empty_button_row']/a";
	FluentWaitHelper waiting = new FluentWaitHelper();

	@Test
	public void NoItemInCart() {
		driver.manage().deleteAllCookies();
		driver.get("https://academybugs.com/find-bugs/#");
		driver.findElement(By.id(blueTshirt)).click();

		WebDriverWait wait = waiting.getWebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(blueTshirtAdded))).click();
		waiting.waitForLoadingMask(driver, 30);

		driver.findElement(By.xpath(deleteProd)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(returnToStore)));

		String returnText = driver.findElement(By.xpath(returnToStore)).getText();
		System.out.println(returnText);
		Assert.assertNotSame(returnText, "RETURN TO STORE", "There is a Extra space");

	}

}
