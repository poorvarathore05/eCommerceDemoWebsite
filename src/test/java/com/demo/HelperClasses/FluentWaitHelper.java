package com.demo.HelperClasses;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.LaunchBrowser;

public class FluentWaitHelper {
	public By msgElement = By.xpath("//*[text()='You found a crash bug, examine the page for 5 seconds.']");
	public By loadingBall = By.xpath("//div[@id='wpeasycart_cart_holder']/div/div/div");

	public WebDriverWait getWebDriverWait(WebDriver driver, int timeOutInSec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSec));
		wait.pollingEvery(Duration.ofMillis(250));
		wait.ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
		return wait;
	}
	
	public void waitForLoadingMask(WebDriver driver, int timeOutInSec){
		WebDriverWait wait = getWebDriverWait(driver,timeOutInSec);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBall));
	}
}
