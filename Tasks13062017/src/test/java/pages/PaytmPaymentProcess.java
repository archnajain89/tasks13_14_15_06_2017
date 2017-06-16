package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
			
			/*//To check whether customer is login or not if not then only below script will run
			WebElement ele= driver.findElement(By.xpath("//div[@class='_3ac-' and text()='Log In/Sign Up']"));*/
			
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
			
			Thread.sleep(2000);
			//Enter Password
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("beyond_1989");
			
			//Click on login button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			
			//Enter OTP manually
			//Thread.sleep(5000);
			//driver.findElement(By.xpath(".//*[@id='input_0']")).sendKeys("538943");
			
	
			//Click on Verify
			Thread.sleep(20000);
			driver.findElement(By.xpath("//*[@class='spinner-new']//following::button[1]")).click();
			
			//Click on Proceed to Pay Rs 100
			Thread.sleep(5000);
			driver.findElement(By.xpath("//li[@class='_2hJA']//button[1]")).click();
			
			//Call Assertion
			Thread.sleep(5000);
			String Exp_title="Paytm Secure Online Payment Gateway";
			PaytmPaymentProcess pay_title=new PaytmPaymentProcess();
			
			System.out.println("Page Title "+driver.getTitle());
						
			boolean ret=pay_title.checktitle(Exp_title);
			Assert.assertTrue(ret, "Page Title");
			
					
			//Click on second card radio option
			List<WebElement> radio_lists=driver.findElements(By.xpath("//label[@class='radio cvvRadio']"));
			System.out.println("No. of radio buttons"+radio_lists.size());
			for(int i=0;i<radio_lists.size();i++)
			{
			rvalue=radio_lists.get(i).isSelected();
			System.out.println(rvalue);
				if(rvalue==false)
				{
				radio_lists.get(i).click();
				
				}
			}
			
			
			//Click on Proceed Securely
		Thread.sleep(20000);
			WebDriverWait wait=new WebDriverWait(driver, 50);
			WebElement ele1=driver.findElement(By.xpath("//div[@class='savedCardbtn']//input[1]"));
			wait.until(ExpectedConditions.elementToBeClickable(ele1));
			ele1.click();
			//driver.findElement(By.xpath("//div[@class='savedCardbtn']//input[1]")).click();

			
			//Click on submit button on payment gateway
			Thread.sleep(5000);
			System.out.println("Authentication page" +driver.getTitle());
			driver.findElement(By.xpath("//input[@title='Click here to Submit']")).click();
			
		}
		
		//Check are we on the right page ?
		public boolean checktitle(String ExpTitle)
		{
			boolean flag=false;
			if(driver.getTitle().equalsIgnoreCase(ExpTitle))
			{
				
				System.out.println("Page Title "+driver.getTitle());
				flag=true;
				
			}
			return flag;
		}
		
		
		
		
}	
