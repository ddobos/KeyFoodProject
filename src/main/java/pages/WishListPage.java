package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.SeleniuWrappers;

public class WishListPage extends SeleniuWrappers {

	public WishListPage(WebDriver driver) {
		super(driver);
	}
	
	public By listProduct = By.cssSelector("td[class=\"product-name\"]>a");
	public String producthHrefIndentificator = "//td[@class='product-name']//a[contains(@href,'%s')]";
	public By selectProductActions = By.id("tinvwl_product_actions");
	public By applyActionBtn = By.name("tinvwl-action");
	public By errorMsgWishlist = By.cssSelector("ul[class='woocommerce-error']");
	
	public boolean productIsInWishlist(String product) {
		String locatorProduct = String.format(producthHrefIndentificator, product);
		return getWebElement(By.xpath(locatorProduct)).isDisplayed() ;
	}
	
	public boolean productHasButton(String product) {
			String locatorButton = String.format(producthHrefIndentificator, product) + "/following::button";
			return getWebElement(By.xpath(locatorButton)).isDisplayed();
	}
	
	public void selectProduct(String product) {
		String checkBox = String.format(producthHrefIndentificator, product) + "//parent::td//parent::tr//input";
		click(By.xpath(checkBox));
	}
	
	public void selectActions(String value) {
		Select selectAction = new Select(getWebElement(selectProductActions));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", selectAction);
		selectAction.selectByValue(value);
	}

}
