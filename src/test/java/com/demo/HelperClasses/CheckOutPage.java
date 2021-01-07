package com.demo.HelperClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//main[@id='main']//table[@class='ec_cart']/tbody//tr[3]/td[6]")
	public WebElement firstProductAmnt;

	@FindBy(xpath = "//main[@id='main']//table[@class='ec_cart']/tbody//tr[6]/td[6]")
	public WebElement secondProductAmnt;

	@FindBy(id = "ec_cart_shipping")
	public WebElement shippingChrg;

	@FindBy(xpath = "//main[@id='main']//table[@class='ec_cart']/tbody//tr[3]/td[5]//td[3]/input")
	public WebElement increaseProdQuantity;

	@FindBy(xpath = "//main[@id='main']//table[@class='ec_cart']/tbody//tr[3]/td[5]//td/div")
	public WebElement updateButton;
	
	@FindBy(id="ec_quantity_185418")
	public WebElement changeQuantity;


}
