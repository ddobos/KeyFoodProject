package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class MyAccountPage extends SeleniuWrappers {
	
//	public WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public By userNameField = By.id("username");
	public By passwordField = By.id("password");
	public By loginButton = By.cssSelector("button[name='login']");
	public By loginErrorMsg = By.cssSelector("ul[class*='error'] strong");
	public By userNameGreetings = By.cssSelector("div[class='woocommerce-MyAccount-content'] strong");
	public By logoutButton = By.linkText("Log out");
	
	public void LoginInUp(String userName, String password) {
		sendKeys(userNameField, userName);
		sendKeys(passwordField, password);
		click(loginButton);
	}
	
	public boolean loginMsgIsDisplay(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	

}
