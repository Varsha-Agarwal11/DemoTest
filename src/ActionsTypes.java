import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTypes 
{
	WebDriver driver;
	
	public void hover(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().perform();
	}
	
	public void hoverClick(WebDriver driver,WebElement ele,WebElement eleClick)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().click(eleClick).build().perform();
	}
	
	@Test
	public void testActions() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.pepboys.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		WebElement serviceAndRepair = driver.findElement(By.xpath("//span[contains(.,'Service & Repair')]"));
		WebElement stateInspection = driver.findElement(By.xpath("//a[contains(.,'State Inspection')]"));
		//hover(driver,serviceAndRepair);
		hoverClick(driver,serviceAndRepair , stateInspection);
		Thread.sleep(3000);
		driver.close();
	}
}
