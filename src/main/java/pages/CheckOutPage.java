package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.SeleniuWrappers;

public class CheckOutPage extends SeleniuWrappers {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	public By termAndConCheckBox = By.id("terms");
	public By placeOrderBtn = By.id("place_order");
	public By mandatoryBillingAddressFields = By.cssSelector("ul[class*='woocommerce-error'] > li");
	public By firstNameField = By.name("billing_first_name");
	public By lastNameField = By.name("billing_last_name");
	public By selectCountryField = By.name("billing_country");
	public By billingField = By.name("billing_address_1");
	public By billing2Field = By.name("billing_address_2");
	public By cityField = By.name("billing_city");
	public By selectStateField = By.name("billing_state");
	public By postcodeField = By.name("billing_postcode");
	public By phoneField = By.name("billing_phone");
	public By emailField = By.name("billing_email");
	public By receivedMsg = By.cssSelector("p[class*='woocommerce-thankyou-order-received']");
	public By receivedOrderNumber = By.cssSelector("li[class*='woocommerce-order-overview__order']>strong");
	
	public void completeBillingInfo() {
		sendKeys(firstNameField, "Denis");
		sendKeys(lastNameField, "Dobos");
		Select selectCountry = new Select(driver.findElement(selectCountryField));
		selectCountry.selectByValue("RO");
		sendKeys(billingField, "Aleea Barajul Bistritei 9");
		sendKeys(billing2Field, "Bl. Z1, Sc. 5, ap. 62");
		sendKeys(cityField, "Bucuresti");
		Select selectState = new Select(driver.findElement(selectStateField));
		selectState.selectByValue("B");
		sendKeys(postcodeField, "032765");
		sendKeys(phoneField,"0720220134");
		sendKeys(emailField,"denis@keyfood.ro");
	}

}
