package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.ProductPage;
import utils.BaseTest;

public class Homework30 extends BaseTest {

	@Parameters({ "user", "pass" })
	@Test(priority = 1)
	public void homeWorkTest1(String user, String pass) {

		app.menu.click(app.menu.myAccountLink);
		app.myAccountPage.LoginInUp(user, pass);

		String findProduct = "Coconut";
		app.sendKeys(app.menu.searchField, findProduct);
		app.click(app.menu.suggestionProduct);

		ProductPage productPage = new ProductPage(driver);
		productPage.click(productPage.addToCartBtn);

		SoftAssert sa = new SoftAssert();

		sa.assertTrue(productPage.checkElementIsDisplayed(productPage.addToCartShowMessage));
		app.click(app.menu.cartLink);

		double pricePerProduct = Double.parseDouble(app.cartPage.getWebElement(app.cartPage.priceProduct).getText().replace('$', ' '));
		int quantity = Integer.parseInt(app.cartPage.getWebElement(app.cartPage.quantityProduct).getAttribute("value"));
		
		app.productPage.increaseProductQty(1);
		quantity++;
		
		sa.assertTrue( quantity == Integer.parseInt(app.cartPage.getWebElement(app.cartPage.quantityProduct).getAttribute("value")));
		app.waitForElementToBeUnclicable(app.cartPage.updateCartBtn);
		sa.assertTrue(quantity * pricePerProduct == Double.parseDouble(app.cartPage.getWebElement(app.cartPage.subTotalProduct).getText().replace('$', ' ')));
		app.click(app.cartPage.proceedButton);
		
		app.click(app.checkOutPage.termAndConCheckBox);
		app.checkOutPage.completeBillingInfo();
		app.click(app.checkOutPage.placeOrderBtn);
		sa.assertTrue(driver.findElement(app.checkOutPage.receivedMsg).getText().contains("Your order has been received."));
		sa.assertTrue(driver.getCurrentUrl().contains(driver.findElement(app.checkOutPage.receivedOrderNumber).getText()));
		sa.assertAll();
	}

}
