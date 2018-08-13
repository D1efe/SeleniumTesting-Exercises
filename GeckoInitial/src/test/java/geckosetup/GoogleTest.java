package geckosetup;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleTest {

	private static WebDriver myDriver;

	@BeforeClass
	public static void setUpBeforeClass() {
		System.setProperty("webdriver.gecko.driver", "/home/dan/Downloads/geckodriver");
	}

	@Before
	public void setUp() {
		myDriver = new FirefoxDriver();
		myDriver.manage().window().maximize();
	}

	@Test
	public void fireFoxInitial() {
		myDriver.get("http://www.google.co.uk");
		WebElement myElement = myDriver.findElement(
				By.cssSelector("#tsf > div.tsf-p > div.jsb > center > input[type=\"submit\"]:nth-child(1)"));
		assertTrue(myElement.isDisplayed());
	}

	@AfterClass
	public static void cleanUp() {
		if (myDriver != null) {
			myDriver.close();
			myDriver.quit();
		}
	}

}