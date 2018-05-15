import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectWholeText 
{
	WebDriver driver;
	
	@Test
	public void testA() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('identifierId').value='pepboysinformation@gmail.com';");
		driver.findElement(By.xpath("//span[contains(.,'Next')]")).click();
		driver.findElement(By.name("password")).sendKeys("pepboys12345",Keys.ENTER,Keys.chord(Keys.CONTROL,"A"));
		Thread.sleep(8000);
		driver.close();
	}
}
