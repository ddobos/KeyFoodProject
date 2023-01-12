package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniuWrappers;

public class BlogPage extends SeleniuWrappers {

	public BlogPage(WebDriver driver) {
		super(driver);
	}
	
	public By commentField = By.id("comment");
	public By submmit = By.id("submit");
	public By readMoreBtn = By.cssSelector("div[class*='entry-button']>a");
	public By commentName = By.cssSelector("div[class='klb-post']");

}
