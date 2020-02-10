package testNG_Autometion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandle {

	WebDriver driver;

	@BeforeMethod

	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.yahoo.com/");

	}

	@Test
	public void switching_From_Yahoo_To_W3_Window() throws InterruptedException {

		By YAHOO_SEARCH_LOCATOR = By.id("header-search-input");
		By W3_LINK_LOCATOR = By.linkText("XPath Tutorial - w3schools.com");

		Thread.sleep(3000);
		driver.findElement(YAHOO_SEARCH_LOCATOR).sendKeys("XPATH");

		driver.findElement(YAHOO_SEARCH_LOCATOR).sendKeys(Keys.ENTER);

		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(W3_LINK_LOCATOR));

		driver.findElement(By.linkText("XPath Tutorial - w3schools.com")).click();

		System.out.println(driver.getWindowHandles());

		for (String windowHanle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHanle);

		}
		Thread.sleep(2000);
		driver.findElement(By.linkText("SQL")).click();

	}

	@AfterMethod

	public void close() {

		driver.close();
		driver.quit();
	}

}
