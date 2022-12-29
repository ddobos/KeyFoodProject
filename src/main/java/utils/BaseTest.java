package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

public class BaseTest extends Driver {

	public static WebDriver driver;

//	@Parameters({"browser", "url"})
	@BeforeClass(alwaysRun = true)
	public void setup() {
		String browser = "chrome";
		String url ="https://keyfood.ro/";
		driver = initDriver(browser);
		driver.get(url);
	}

	@AfterClass
	public void tearTeste() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	@AfterMethod
	public void recordFailure(ITestResult testResult) {

		if (ITestResult.FAILURE == testResult.getStatus()) {
			TakesScreenshot poza = (TakesScreenshot) driver;
			File picture = poza.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

			try {
				Files.copy(picture, new File("screenshots/" + testResult.getName() + '-' + timeStamp + ".png"));
				System.out.println("Picture saved");
			} catch (IOException e) {
				System.out.println("Picture could not by saved");
				e.printStackTrace();
			}
		}
	}

}
