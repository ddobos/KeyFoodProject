package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MenuPage;
import pages.MyAccountPage;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class LoginTest extends BaseTest {
	
	@Parameters({"user", "pass"})
	@Test(priority = 1)
	public void validTest(String user, String pass) {
		MenuPage menu = new MenuPage(driver);
		MyAccountPage myAccount = new MyAccountPage(driver);
		
		menu.click(menu.myAccountLink);
		myAccount.LoginInUp(user, pass);
		assertTrue(myAccount.loginMsgIsDisplay(myAccount.userNameGreetings));
		
		myAccount.click(myAccount.logoutButton);
	}
	
	@Parameters({"invalidUser", "invalidPass"})
	@Test(priority = 2)
	public void invalidTest(String user, String pass) {
		MenuPage menu = new MenuPage(driver);
		MyAccountPage myAccount = new MyAccountPage(driver);
		
		menu.click(menu.myAccountLink);
		myAccount.LoginInUp(user, pass);
		assertTrue(myAccount.loginMsgIsDisplay(myAccount.loginErrorMsg));
	}

}
