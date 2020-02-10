package techfiosTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
	
	@Test
	
	public void validUserShouldBeLogIn() {
	//setting chrome as a default browser
		
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		
		//open chrome  browser
		
		WebDriver driver = new ChromeDriver();
		//go to techfios website
		
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		
		//Type username in username field
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		
		//type password in the field
		driver.findElement(By.name("password")).sendKeys("abc123");
		
		//click login
		driver.findElement(By.name("login")).click();
		
		//verify title
		
		driver.getTitle();
		
		
		
		
	}	
	
	
	
	
	
	
	
	
	
	
	

}
