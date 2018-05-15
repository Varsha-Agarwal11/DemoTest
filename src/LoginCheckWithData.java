import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginCheckWithData 
{
	WebDriver driver;
	
	@Test(enabled = false)
	public void loginTestAdmin() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement username  = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		
		String adminCredentials = Data.getCredentials().get("admin");
		String adminInfo[] = adminCredentials.split("_");
		username.sendKeys(adminInfo[0]);
		password.sendKeys(adminInfo[1]);
		
		WebElement login = driver.findElement(By.xpath("//input[contains(@value,'Login')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",login); 
		Thread.sleep(2000);
		driver.switchTo().frame("");
		driver.close();
	}
	
	@Test(enabled = true)
	public void loginTestCustomer()
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement username  = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		
		String adminCredentials = Data.getCredentials().get("customer");
		String adminInfo[] = adminCredentials.split("_");
		username.sendKeys(adminInfo[0]);
		password.sendKeys(adminInfo[1]);
		
		WebElement login = driver.findElement(By.xpath("//input[contains(@value,'Login')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",login); 
		driver.close();
	}
}
