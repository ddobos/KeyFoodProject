package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class CheckOutPage extends SeleniuWrappers {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	public By termAndConCheckBox = By.id("terms");
	public By placeOrderBtn = By.id("place_order");
	public By mandatoryBillingAddressFields = By.cssSelector("ul[class*='woocommerce-error'] > li");

}
