import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScript 
{
	public static WebDriver driver;
	
	public static void flash(WebElement element,WebDriver driver) throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0;i<100;i++)
		{
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
	}
	public static void changeColor(String color,WebElement element,WebDriver driver) throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'" ,element);
	}
	
	public static void drawBorder(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver,String msg)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+msg+"')",msg);
	}
	
	public static void clickByJS(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshByJS(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public static String getTitleByJS(WebDriver driver)
	{	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static String getPageInnerText(WebDriver driver)
	{	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String innerText = js.executeScript("return document.documentElement.innerText;").toString();
		return innerText;
	}
	
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollIntoView(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	@Test
	public void jsTest1() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.freecrm.com/index.html");
		
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("varshaagrwal12@gmail.com");
		driver.findElement(By.name("password")).sendKeys("radhekrishna11");
		WebElement login = driver.findElement(By.xpath("//input[contains(@value,'Login')]"));
		flash(login,driver);
		drawBorder(login,driver);
		Thread.sleep(2000);
		/*generateAlert(driver, "I am alert!!");
		driver.switchTo().alert().accept();
		Thread.sleep(2000);*/
		clickByJS(login, driver);
		Thread.sleep(2000);
		refreshByJS(driver);
		String title = getTitleByJS(driver);
		System.out.println("Title : "+title);
		String innerText = getPageInnerText(driver);
		System.out.println("Innertext : "+innerText);
		/*EventFiringWebDriver e = new EventFiringWebDriver(driver);
		File src = e.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Snap/fail.png");
		FileUtils.copyFile(src,dest);*/
		//scrollDown(driver);
		//Thread.sleep(2000);
		WebElement forgot_pwd = driver.findElement(By.xpath("//div[contains(@class,'col-sm-6 margin copy')]//a[contains(.,'Forgot Password')]")); 
		scrollIntoView(forgot_pwd,driver);
		Thread.sleep(2000);
		driver.close();
	}
}
