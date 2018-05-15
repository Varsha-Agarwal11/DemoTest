import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertPopUpByJS 
{
	WebDriver driver;
	
	@Test
	public void alertJS() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.rediff.com/");
		driver.findElement(By.xpath("//a[contains(.,'Sign in')]")).click();
		driver.findElement(By.xpath("//input[contains(@value,'Go')]")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		Thread.sleep(2000);
		driver.close();
	}
}
