package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaytmPaymentProcess 
{
	static WebDriver driver;
		public static void main (String args[]) throws InterruptedException
		{
			boolean rvalue=false;
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://paytm.com/");
			
			Thread.sleep(5000);
			
			//select post paid radio button
			/*List<WebElement> radiobtn=driver.findElements(By.xpath(".//*[contains(@id,'radio')]"));
			System.out.println("No. of radio buttons "+radiobtn.size());
			
			Thread.sleep(5000);
		
			for(int i=0;i<radiobtn.size();i++)
			{
			rvalue=radiobtn.get(i).isSelected();
			System.out.println(rvalue);
			if(rvalue==false)
			{
				radiobtn.get(i).click();
				
			}
			}*/
			
			//To enter Mobile Number
			driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("8588022146");
			//driver.findElement(By.xpath("//div[@class='vltX']//div[1]//input[1]")).sendKeys("100");
			
			//To enter amount
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='vltX']//div[1]//input[1]")).sendKeys("100");
		
			//click on Proceed button
			driver.findElement(By.xpath("//button[contains(text(),'Proceed to Pay Bill')]")).click();
			
			Thread.sleep(5000);
			//Click on Proceed to Pay
			driver.findElement(By.xpath("//button[@class='_11kC _2CKY _15qf _2qE6']")).click();
			
			//Switch to frame
			Thread.sleep(5000);
			List<WebElement> List = driver.findElements(By.tagName("iframe"));
			System.out.println("Number of frames "+List.size());
			driver.switchTo().frame(0);
			
			Thread.sleep(5000);
			//Enter email ID
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("archnajain89@gmail.com");
			
			Thread.sleep(5000);
			//Enter Password
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("beyond_1989");
			
			//Click on login button
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			
			//Click on Verify
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//*[@class='spinner-new']//following::button[1]")).click();
			driver.findElement(By.xpath(".//*[@id='input_0']")).sendKeys("504697");
			}
}	
