import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadViaSendKeys 
{
	public static WebDriver driver;
	
	@Test
	public void fileUpload() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://html.com/input-type-file/");
		try
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
		}
		catch(Exception e)
		{}
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.id("fileupload"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",ele);
		ele.sendKeys("C:\\Users\\virsha.agarwal\\Desktop");
		Thread.sleep(2000);
		driver.close();
	}
}
