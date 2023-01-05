package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class MenuPage extends SeleniuWrappers {

//	public WebDriver driver;

	public MenuPage(WebDriver driver) {
		super(driver);
	}
	
	public By myAccountLink = By.linkText("My account");
	public By searchField = By.cssSelector("input[type='search']");
	public By suggestionProduct = By.cssSelector("a[class*='dgwt-wcas-suggestion']");
	public By cartLink = By.linkText("CART");
	

}
