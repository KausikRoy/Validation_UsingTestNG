package testNG_Autometion;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlePopUps {

	WebDriver driver;

	@BeforeMethod

	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
	}

	@Test

	public void handlePopUpAndframes() throws InterruptedException {

		driver.findElement(By.name("proceed")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
			
		
	}

	@AfterMethod

	public void close() {

	driver.close();
		driver.quit();
	}

}
