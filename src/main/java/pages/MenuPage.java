package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	public By blogLink = By.linkText("BLOG");
	public By allCategoriesLink = By.cssSelector("div[class*='all-categories']");
	public By listOfCategori = By.cssSelector("ul[class*='menu-list']>li");
	public By wishlistLink = By.linkText("Wishlist");
	public By countCartProduct = By.cssSelector("span[class='cart-count-icon']");
	
	public void getCategoryFromList(int category) {
		click(allCategoriesLink);
		List<WebElement> listCategories = driver.findElements(listOfCategori);
		if (category < listCategories.size())
			listCategories.get(category).click();
	}
	

}
