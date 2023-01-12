package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class ProductPage extends SeleniuWrappers {
	
//	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
//		this.driver = driver;
		super(driver);
	}
	
	public By addToCartBtn = By.cssSelector("button[name='add-to-cart']");
	public By addToCartShowMessage = By.cssSelector("div[role='alert']");
	public By increaseQtyBtn = By.xpath("(//i[@class='klbth-icon-plus'])[1]");
	public By salePrice = By.cssSelector("p[class='price'] ins>span[class*='amount']");
	public String producthHrefIndentificator = "div[class*='type-product'] a[href*='%s']";
	public By addToWishListButton = By.cssSelector("div[class='product-actions'] a[aria-label='Add to Wishlist']");
	public By closeAddToWishlistButton = By.cssSelector("button[class*='button_close']");
	
	public double getProducSalePrice() {
		String price = driver.findElement(salePrice).getText().replace("$", "");
		return Double.parseDouble(price);
	}
	
	public void increaseProductQty(int times) {
		for (int i = 0; i < times; i++) {
			click(increaseQtyBtn);
		}
	}
	
	public String getAddedToCartAlertMessage() {
		return driver.findElement(addToCartShowMessage).getText().replace("View cart", "").substring(1);
	}
	
	public void clickProductByName(String productName) {
		String locator = String.format(producthHrefIndentificator, productName);
		click(By.cssSelector(locator));
	}
	
}
