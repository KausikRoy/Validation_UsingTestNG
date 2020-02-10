package testNG_Autometion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingFrames {

	WebDriver driver;

	@BeforeMethod

	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://docs.oracle.com/javase/8/docs/api/index.html");

	}

	@Test

	public void handleframes() throws InterruptedException {

		By Java_Applet_Locator = By.linkText("java.applet");
		By ApletContext_Locator = By.xpath("//a/span[contains(text(),'AppletContext')]");

		driver.switchTo().frame("classFrame");
		// tried clicking the locator but frame was not the default frame so need to
		// switch the frame
		driver.findElement(Java_Applet_Locator).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("packageFrame");
		Thread.sleep(3000);
		driver.findElement(ApletContext_Locator).click();
		Thread.sleep(3000);

	}

	@AfterMethod

	public void close() {

		driver.close();
		driver.quit();
	}

}
