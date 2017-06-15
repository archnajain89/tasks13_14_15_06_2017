package pages;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlepopups 
{
	static WebDriver driver;
	public static void main (String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Handlepopups hp=new Handlepopups();
		//hp.alertHandle();
		//hp.handleWindowpopups();
		hp.handleframes();
		
	}
		
		
	public void alertHandle() throws InterruptedException
	{
		//Navigate to given URL
		driver.navigate().to("http://demo.guru99.com/V4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//find xpath for login and click
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		Thread.sleep(5000);
		
		//To handle alert popups
		Alert alert=driver.switchTo().alert();
		String alert_text=alert.getText();
		System.out.println(alert_text);
		alert.accept();
		System.out.println("Alert Accepted");
		
	}	
	
	
	public void handleWindowpopups() throws InterruptedException
	{
		driver.navigate().to("http://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		String mainwindowhandle=driver.getWindowHandle();
		System.out.println(mainwindowhandle);
		
		//xpath of login button !!
		driver.findElement(By.xpath("//a[@id='loginsubmit']")).click();
		
		//xpath of NetBanking!!
		//driver.findElement(By.xpath("//a[text()='Continue to NetBanking']")).click();
		
		//To handle all child windows
		Set<String> s1=driver.getWindowHandles();
		System.out.println(s1);
		
		Iterator<String> i1=s1.iterator();
		
		while(i1.hasNext())
		{
			
			i1.next();
			String childwindow=i1.next();
			System.out.println(childwindow);
			
			if(!mainwindowhandle.equalsIgnoreCase(childwindow))
			{
			
				driver.switchTo().window(childwindow);
				Thread.sleep(5000);
				driver.findElement(By.xpath("//div[@class='pdtb25 text-center']//a[text()='Continue to NetBanking']")).click();		
	            Thread.sleep(5000);                     
				// Closing the Child Window.
	            //driver.close();	
			}
		}
		
		// Switching to Parent window i.e Main Window.
        driver.switchTo().window(mainwindowhandle);
			
	}
	
	public void handleframes() throws InterruptedException
	{
		driver.navigate().to("http://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
		List<WebElement> List = driver.findElements(By.tagName("iframe"));
		//System.out.println(List);
		System.out.println("No of iframes on this page is "+List.size());
		
	
		for(WebElement ele: List)
		{
		driver.switchTo().frame(ele);
		
		}
		
			
	}
	
	
		
}
