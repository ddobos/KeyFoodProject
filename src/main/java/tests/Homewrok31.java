package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.BaseTest;

public class Homewrok31 extends BaseTest {

	@Parameters({ "user", "pass" })
	@Test(priority = 1)
	public void homewrokTest1(String user, String pass) {

		app.click(app.menu.myAccountLink);
		app.myAccountPage.LoginInUp(user, pass);

		String[] products = new String[] { "melon", "egg-bites", "pastel-almond", "strawberry-lemonade" };
		Integer[] categories = { 0, 2, 6, 3 };
		for (int ind = 0; ind < 4; ind++) {
			setToWishlist(categories[ind], products[ind]);
		}

		app.click(app.menu.wishlistLink);
		
		SoftAssert sa = new SoftAssert();

		for (String product : products) {
			sa.assertTrue(app.wishlistPage.productIsInWishlist(product) && app.wishlistPage.productHasButton(product));
			app.wishlistPage.selectProduct(product);
		}
		
		app.wishlistPage.selectActions("add_selected");
		app.click(app.wishlistPage.applyActionBtn);
		
		sa.assertTrue(app.getWebElement(app.wishlistPage.errorMsgWishlist).isDisplayed());
		sa.assertTrue(app.getWebElement(app.menu.countCartProduct).getText().equalsIgnoreCase("3"));
		
		sa.assertAll();

		app.click(app.menu.myAccountLink);
		app.click(app.myAccountPage.logoutButton);

	}

	private void setToWishlist(int category, String product) {
		app.menu.getCategoryFromList(category);
		app.productPage.clickProductByName(product);
		app.click(app.productPage.addToWishListButton);
		app.getWebElement(app.productPage.closeAddToWishlistButton).click();
	}

}
