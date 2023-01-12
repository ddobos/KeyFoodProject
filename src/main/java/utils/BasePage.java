package utils;

import org.openqa.selenium.WebDriver;

import pages.BlogPage;
import pages.CartPage;
import pages.CheckOutPage;
import pages.MenuPage;
import pages.MyAccountPage;
import pages.ProductPage;
import pages.WishListPage;

public class BasePage extends SeleniuWrappers {

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	public MenuPage menu = new MenuPage(driver);
	public MyAccountPage myAccountPage = new MyAccountPage(driver);
	public ProductPage productPage = new ProductPage(driver);
	public CartPage cartPage = new CartPage(driver);
	public CheckOutPage checkOutPage = new CheckOutPage(driver);
	public BlogPage blogPage = new BlogPage(driver);
	public WishListPage wishlistPage = new WishListPage(driver);

}
