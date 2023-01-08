package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class CartPage extends SeleniuWrappers {
	
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public By plusProduct = By.cssSelector("div[class*='plus']");
	public By minusProduct = By.cssSelector("div[class*='minus']");
	public By priceProduct = By.cssSelector("td[class*='price'] span[class*='amount']>bdi");
	public By subTotalProduct = By.cssSelector("td[class*='subtotal'] span[class*='amount']>bdi");
	public By quantityProduct = By.cssSelector("input[id*='quantity']");
	public By proceedButton = By.linkText("Proceed to checkout");
	
	public By updateCartBtn = By.name("update_cart");
	
	public By totalPrice = By.cssSelector("td[data-title='Total'] span[class*='woocommerce-Price-amount']");
	
	public double getTotalPrice() {
		return Double.parseDouble(driver.findElement(totalPrice).getText().substring(1));
	}
	
}
