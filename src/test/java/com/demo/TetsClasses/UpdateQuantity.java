package com.demo.TetsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.demo.LaunchBrowser;
import com.demo.HelperClasses.CheckOutPage;
import com.demo.HelperClasses.FluentWaitHelper;

public class UpdateQuantity extends LaunchBrowser {

	private String prodAddToCart = "ec_add_to_cart_5";
	private String prodAddedToCart = "ec_added_to_cart_5";
	FluentWaitHelper wait = new FluentWaitHelper();
	

	@Test
	public void updateProdQuantity() {
		driver.manage().deleteAllCookies();
		driver.get("https://academybugs.com/find-bugs/#");
		WebDriverWait waiter = wait.getWebDriverWait(driver, 30);
		driver.findElement(By.id(prodAddToCart)).click();

		waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id(prodAddedToCart))).click();
		wait.waitForLoadingMask(driver, 30);
		CheckOutPage checkOut = new CheckOutPage(driver);
		// checkOut.changeQuantity.sendKeys("3");
		checkOut.increaseProdQuantity.click();
		checkOut.updateButton.click();

	}
}
