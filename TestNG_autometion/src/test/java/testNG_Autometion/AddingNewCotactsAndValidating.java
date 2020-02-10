package testNG_Autometion;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddingNewCotactsAndValidating {

	WebDriver driver;

	@BeforeMethod

	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

	}

	@Test
	public void addingAndValidatingNewCotact() throws InterruptedException {
		String AccountName = "Roy :" + new Random().nextInt(9999);
		By CRM_Locator = By.xpath("//span[text()='CRM']");
		By Add_Contact_Locator = By.linkText("Add Contact");
		By FullNamee_Locator = By.id("account");
		By Com_NameLocator = By.id("company");
		By Email_Locator = By.id("email");
		By Phone_Locator = By.id("phone");
		By Address_Locator = By.id("address");
		By City_Locator = By.id("city");
		By State_Locator = By.id("state");
		By Zip_Locator = By.id("zip");
		By Submit_Locator = By.id("submit");
		By firstTableDataLocator = By.xpath("//a[contains(text(), '" + AccountName + "')]");
		//waitForElement(driver, 45, firstTableDataLocator);
		
		driver.findElement(CRM_Locator).click();
		driver.findElement(Add_Contact_Locator).click();
		Thread.sleep(3000);
		driver.findElement(FullNamee_Locator).sendKeys(AccountName);
		driver.findElement(Com_NameLocator).sendKeys("Bright Light");
		driver.findElement(Email_Locator).sendKeys("Rkausik78@gmail.com");
		driver.findElement(Phone_Locator).sendKeys("203 -359- 8977");
		driver.findElement(Address_Locator).sendKeys("5301 Alpha Road");
		driver.findElement(City_Locator).sendKeys("Dallas");
		driver.findElement(State_Locator).sendKeys("Texas");
		driver.findElement(Zip_Locator).sendKeys("75240");
		driver.findElement(Submit_Locator).click();
		driver.findElement(By.linkText("List Contacts"));
		//Assert.assertEquals(firstTableDataLocator, expected, "Account not added!");

	}

	private void waitForElement(WebDriver driver, int timeToWaitInSeconds, By ElementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ElementLocator));

	}

	@AfterMethod

	public void close() {

		//driver.close();
		//driver.quit();
	}

}
