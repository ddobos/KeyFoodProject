package utils;

import org.openqa.selenium.WebDriver;

import pages.CartPage;
import pages.CheckOutPage;
import pages.MenuPage;
import pages.MyAccountPage;
import pages.ProductPage;

public class BasePage extends SeleniuWrappers {

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	public MenuPage menu = new MenuPage(driver);
	public MyAccountPage myAccountPage = new MyAccountPage(driver);
	public ProductPage productPage = new ProductPage(driver);
	public CartPage cartPage = new CartPage(driver);
	public CheckOutPage checkOutPage = new CheckOutPage(driver);

}
