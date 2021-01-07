package com.demo.TetsClasses;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.LaunchBrowser;

public class DenimCoatColorChange extends LaunchBrowser {

	private String selectDress ="ec_product_image_effect_SKU7505";
	private String dressImage = "//div[@class ='ec_details_option_row']//li[3]/img";
	private String dressColor ="//div[@class ='ec_details_option_row']/div/div";
	@Test
	public void colorChange(){
		driver.manage().deleteAllCookies();
		driver.get("https://academybugs.com/find-bugs/#");
		driver.findElement(By.id(selectDress)).click();
		driver.findElement(By.xpath(dressImage)).click();
		String colorName = driver.findElement(By.xpath(dressColor)).getText();
		System.out.println(colorName);
		Assert.assertNotSame(colorName, "Orange", "Color name is miss-spelled ");
	}
}
