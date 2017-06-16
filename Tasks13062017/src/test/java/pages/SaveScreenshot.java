package pages;
import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaveScreenshot 
{
	
		public static WebDriver driver;
	
		public static void main(String[] args) throws InterruptedException, AWTException, IOException 
		{
			
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://www.flipkart.com/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
			WebElement ele = driver.findElement(By.xpath("//div[@class='aqWyJi']"));
			
			//To create folder for saving screenshot
			File dir = new File("D://mysoftware//bhavna//Tasks13062017//ScreenShot");
			if (!dir.exists()) 
			{
				System.out.println("File created " + dir);
				dir.mkdir();
			}
			
			Thread.sleep(5000);
			takescreenShot(ele);
					
		}
		
			public static void takescreenShot(WebElement element) throws IOException
			{
				
			Point p = element.getLocation();	
			System.out.println(p);
			
			
		    File f1 =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		        int width = element.getSize().getWidth();
		        int height = element.getSize().getHeight();
		        
		        System.out.println("Width "+width);
		        System.out.println("Height "+height);
		        
		        
		        BufferedImage img = ImageIO.read(f1);

		        BufferedImage dest = img.getSubimage(p.getX(), p.getY(),width,height);
		        System.out.println(p.getX());
		        System.out.println(p.getY());

		        ImageIO.write(dest, "png", f1);
		        String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());

			    File f2=new File("D://mysoftware//bhavna//Tasks13062017//Screenshot//"+filename+".png");
			    
			    FileUtils.copyFile(f1, f2);
			    
			    
		    /*//Save screenshot
			
		    File f1 =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    
		    String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());

		    File f2=new File("D://mysoftware//bhavna//Tasks13062017//Screenshot//"+filename+".png");
		    
		    FileUtils.copyFile(f1, f2);
		    System.out.println(filename+".png"+" ScreenShot saved successfully!!!!!!!");*/
		    
			}	
		     
		     
}

		
		
		

