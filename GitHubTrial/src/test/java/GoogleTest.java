

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

	@Test
	public void openGoogleSite() {

		// setting chromeDriver property
		System.setProperty("webdriver.chrome.driver", ".//driver//chromedriver.exe");

		// create an object of ChromeDriver

		WebDriver driver = new ChromeDriver();

		// go to google site
		driver.get(
				"https://accounts.google.com/signin/v2/identifier?hl=en&passive=true&continue=https%3A%2F%2Fwww.google.com%2F&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.name("identifier")).sendKeys("rkausik74@gmail.com");

	}

}
