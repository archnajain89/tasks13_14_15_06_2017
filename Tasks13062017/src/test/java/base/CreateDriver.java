package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class CreateDriver 
{

	public WebDriver driver;
	@BeforeSuite
	public void StartBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver=new ChromeDriver();
		
		//driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
		driver.get("http://www.ironspider.ca/forms/checkradio.htm");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
			
	}
	
	
/*	@AfterSuite
	public void EndBrowser()
	{
		driver.quit();
	}
*/	
}
