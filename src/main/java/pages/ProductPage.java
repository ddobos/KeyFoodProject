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
	
}
