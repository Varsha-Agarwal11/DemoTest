import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.annotations.Test;


public class Snap 
{
	WebDriver driver;
	public static final String SNAP_PATH="./Snap/";
	
	//String folder = SNAP_PATH;
	
	public static String getFormatedDateTime()
	{
		SimpleDateFormat sd = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		return sd.format(new Date());
	}
	
	public static void getDesktopScreenshot(String folder)
	{
		String timeStamp=getFormatedDateTime();
		try
		{
			Object ctr = Collections.reverseOrder();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRect = new Rectangle(d);
			Robot r=new Robot();
			BufferedImage img = r.createScreenCapture(screenRect);
			File output=new File(folder + timeStamp + ".png"); 		
			ImageIO.write(img, "png", output);
		}
		catch(Exception e)
		{}
	}
	
	public static String getPageScreenShot(WebDriver driver, String imageFolderPath)
	{
		String imagePath=imageFolderPath+"/"+getFormatedDateTime()+".png";
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		File snap = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		return imagePath;
	}
	
	@Test
	public void snap()
	{
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.pepboys.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//getPageScreenShot(driver,folder);
		getDesktopScreenshot(SNAP_PATH);
		driver.close();
	}
}
