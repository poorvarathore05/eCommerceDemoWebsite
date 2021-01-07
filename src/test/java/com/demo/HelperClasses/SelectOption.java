package com.demo.HelperClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.demo.LaunchBrowser;

public class SelectOption extends LaunchBrowser {

	public static Select select = null;

	public static void selectByValue(By locator, String value) {

		select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public static void selectByVisisbleText(By locator, String text) {

		select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public static void selectByIndex(By locator, int index) {

		select = new Select(getElement(locator));
		select.selectByIndex(index);

	}
}
