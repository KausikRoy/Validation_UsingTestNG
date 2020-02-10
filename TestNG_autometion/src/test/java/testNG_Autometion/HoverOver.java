package testNG_Autometion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverOver {

	WebDriver driver;

	@BeforeMethod

	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.dell.com/en-us?~ck=mn");

	}

	@Test
	public void handleMouseOver() {

		// instantiating Actions class
		Actions action = new Actions(driver);

		WebElement DEALS_MENU_ELEMENT = driver.findElement(By.xpath("//button[@id='l1_4']"));
		By WORK_STATION_DEAL_LOCATOR = By.linkText("Workstation Deals");

		action.moveToElement(DEALS_MENU_ELEMENT).build().perform();
		waitForElement(driver,15,By.linkText("Workstation Deals"));
		driver.findElement(WORK_STATION_DEAL_LOCATOR).click();

	}

	private void waitForElement(WebDriver driver, int timeToWaitInSeconds, By ElementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ElementLocator));

	}

	@AfterMethod

	public void close() {

		driver.close();
		driver.quit();
	}

}
