package demosite;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoSiteTest {

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
		myDriver.get("http://thedemosite.co.uk/addauser.php");
		WebElement redirect = myDriver.findElement(By.linkText("3. Add a User"));

		WebElement myUsername = myDriver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		WebElement myPassword = myDriver.findElement(By.xpath(
				"/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		WebElement confirm = myDriver.findElement(By.linkText("FormsButton2"));

//		redirect.click();
		myUsername.sendKeys("BotUser1");
		myPassword.sendKeys("password");
		confirm.submit();

		// assertTrue(myElement.isDisplayed());

	}

	// @AfterClass
	// public static void cleanUp() {
	// if (myDriver != null) {
	// myDriver.close();
	// myDriver.quit();
	// }
	// }

}