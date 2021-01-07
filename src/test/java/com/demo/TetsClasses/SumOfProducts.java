package com.demo.TetsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.LaunchBrowser;
import com.demo.HelperClasses.CheckOutPage;
import com.demo.HelperClasses.FluentWaitHelper;

public class SumOfProducts extends LaunchBrowser {

	private String productOne = "ec_add_to_cart_25";
	private String productTwo = "ec_add_to_cart_24";
	private String productTwoAdded = "ec_added_to_cart_24";
	private FluentWaitHelper waiter = new FluentWaitHelper();

	@Test
	public void productsSum() {
		driver.manage().deleteAllCookies();
		driver.get("https://academybugs.com/find-bugs/#");
		closeCookiesPopUp(driver);

		WebDriverWait wait = waiter.getWebDriverWait(driver, 30);
		driver.findElement(By.id(productOne)).click();
		driver.findElement(By.id(productTwo)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(productTwoAdded)));
		driver.findElement(By.id(productTwoAdded)).click();
		waiter.waitForLoadingMask(driver, 30);

		CheckOutPage check = new CheckOutPage(driver);

		String firstProdPrice = check.firstProductAmnt.getText();
		String SecondProdPrice = check.secondProductAmnt.getText();
		String shippingCharge = check.shippingChrg.getText();

		Double totalAmount = totalProductAmount(firstProdPrice) + totalProductAmount(SecondProdPrice)
				+ totalProductAmount(shippingCharge);
		System.out.println("Total Amount " + totalAmount);
		String CartSubTotal = driver.findElement(By.id("ec_cart_total")).getText();

		Double subTotal = totalProductAmount(CartSubTotal);
		System.out.println("SubTotal Amount " + subTotal);
		Assert.assertNotEquals(totalAmount, subTotal , "Function Error - Subtotal must be Same");

	}

	private void closeCookiesPopUp(WebDriver wDriver) {

		try {
			wDriver.findElement(By.xpath("//div[@class='cc-compliance cc-highlight']/a[2]")).click();
		} catch (Exception e) {
			System.out.println("Cookies Popup Not Present");
		}
	}

	private double totalProductAmount(String amount) {

		amount = amount.substring(1);
		double total = Double.parseDouble(amount);
		return total;
	}
}
