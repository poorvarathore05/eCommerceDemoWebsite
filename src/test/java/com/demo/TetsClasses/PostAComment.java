package com.demo.TetsClasses;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demo.LaunchBrowser;


public class PostAComment extends LaunchBrowser {

	private By bangle = By.id("ec_product_image_effect_boho-bangle-bracelet");
	private By comment = By.id("academy-comment-submit");
	public By msgElement = By.xpath("//*[text()='You found a crash bug, examine the page for 5 seconds']");
	

	@Test
	public void postComment() {
		driver.manage().deleteAllCookies();
		driver.get("https://academybugs.com/find-bugs/#");
		driver.findElement(bangle).click();
		driver.findElement(comment).click();
		Assert.assertNotNull(getElement(msgElement), "There is an Error message on Page...");
		

	}

}
