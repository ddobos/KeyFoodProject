package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class ProductPage extends SeleniuWrappers {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By addCart = By.cssSelector("button[name='add-to-cart']");
	public By addCartShowMessage = By.cssSelector("div[role='alert']");
	
}
