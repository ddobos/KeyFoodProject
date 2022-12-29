package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class CartPage extends SeleniuWrappers {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By plusProduct = By.cssSelector("div[class*='plus']");
	public By minusProduct = By.cssSelector("div[class*='minus']");
	public By priceProduct = By.cssSelector("td[class*='price'] span[class*='amount']>bdi");
	public By subTotalProduct = By.cssSelector("td[class*='subtotal'] span[class*='amount']>bdi");
	public By quantityProduct = By.cssSelector("input[id*='quantity']");
	public By proceedButton = By.linkText("Proceed to checkout");
	
}
