package utils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniuWrappers extends BaseTest {
	
	public WebElement getWebElement(By locator) {
		waitForELementToBeVisible(locator);
		return driver.findElement(locator);
	}
	
	public List<WebElement> getWebElements(By locator) {
		waitForELementToBeVisible(locator);
		return driver.findElements(locator);
	}

	public void click(By locator) {
		try {
			
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.elementToBeClickable(locator));
			waitForElementToBeClicable(locator);
			WebElement element = driver.findElement(locator);
			Log.info("caled method <Click()> on element : " + element.getAttribute("outherHTML"));
			element.click();
		} catch (NoSuchElementException e) {
			Log.error("Element not found on methode <Click()> after wait specified sec");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}
	}

	public void waitForElementToBeClicable(By locator) {
		try {
			Log.info("Called methos <WaitForElementToBeClicable()> on element with locator : " + locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch(NoSuchElementException e) {
			Log.error("Element not found on methode <WaitForElementToBeClicable()()> after wait specified sec");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public void waitForELementToBeVisible(By locator) {
		try {
			Log.info("Called methos <WaitForElementToVisible()> on element with locator : " + locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(NoSuchElementException e){
			Log.error("Element not found on methode <WaitForElementToBeVisible()()> after wait specified sec");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public static boolean checkElementIsDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void sendKeys(By locator, String textToBeSend) {
		try {
			
			waitForELementToBeVisible(locator);
			WebElement element = driver.findElement(locator);
			Log.info("Called clear on methode <sendKeys()> on element " + element.getAttribute("outherHTML"));
			element.clear();
			Log.info("Called sendKeys on methode <sendKeys()> on element " + element.getAttribute("outherHTML"));
			element.sendKeys(textToBeSend);
		}catch(NoSuchElementException e) {
			Log.error("Failed method <sendKeys()> with error " + e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public void hoverElement(By locator) {
		try{
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(locator)).perform();
		}
		catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
		}
	}
	
	public void dragAndDrop(By locator, int x, int y) {
		try {
			Actions action = new Actions(driver);
			action.dragAndDropBy(driver.findElement(locator), x, y).perform();
		}catch(NoSuchElementException e) {
			throw new TestException(e.getMessage());
		}
	}
	
	public void filterByIndex(By locator, int index) { //42
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByIndex(index);
		
	}
	
	public void filterByValue(By locator, String value) {
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByValue(value);
	}
	
	public String getFilterValue(By locator) {
		Select dropdown = new Select(driver.findElement(locator));
		return dropdown.getFirstSelectedOption().getText();
	}

}
