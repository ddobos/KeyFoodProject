package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CartPage;
import pages.MenuPage;
import pages.MyAccountPage;
import pages.ProductPage;
import utils.BaseTest;

public class Homework30 extends BaseTest {
	
//	@Parameters({"user", "pass"})
	@Test(priority = 1)
	public void homeWorkTest1() {
		String user = "denis"; 
		String pass = "denis@123";
		MenuPage menu = new MenuPage(driver);
		MyAccountPage myAccount = new MyAccountPage(driver);
		
		menu.click(menu.myAccountLink);
		myAccount.LoginInUp(user, pass);
		
		String findProduct = "Coconut";
		menu.sendKeys(menu.searchField, findProduct);
		menu.click(menu.suggestionProduct);
		
		ProductPage productPage = new ProductPage(driver);
		productPage.click(productPage.addCart);
		
		SoftAssert sa= new SoftAssert();
		
		sa.assertTrue(productPage.checkElementIsDisplayed(productPage.addCartShowMessage));
		menu.click(menu.cartLink);
		
		CartPage cartPage = new CartPage(driver);
		double price = Double.parseDouble(cartPage.getWebElement(cartPage.priceProduct).getText().replace('$', ' '));
		System.out.println(price);
		int quantity = Integer.parseInt(cartPage.getWebElement(cartPage.quantityProduct).getAttribute("value"));
		System.out.println(quantity);
		cartPage.click(cartPage.plusProduct);
		sa.assertTrue(++quantity == Integer.parseInt(cartPage.getWebElement(cartPage.quantityProduct).getAttribute("value")));
		System.out.println(Integer.parseInt(cartPage.getWebElement(cartPage.quantityProduct).getAttribute("value")));
		sa.assertTrue(quantity * price == Double.parseDouble(cartPage.getWebElement(cartPage.subTotalProduct).getText().replace('$', ' ')));
		System.out.println("SubTotal"+(cartPage.getWebElement(cartPage.subTotalProduct).getText()));
		System.out.println("Check SubTotal" + quantity * price);
		sa.assertAll();
		cartPage.click(cartPage.minusProduct);
		cartPage.click(cartPage.proceedButton);
	}

}
