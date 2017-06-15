package pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Randomlink 
{

	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com/account/login?ret=%2Faccount%2Forders");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Find all <a> tags in particular area
		List <WebElement> ele=driver.findElements(By.xpath("//div[@class='_3qd5C5 col col-4-12']//following-sibling::a"));
		
		//List for storing all href values for 'a' tag
		 ArrayList<String> hrefs = new ArrayList<String>(); 

		System.out.println("Total links present on particular area"+ele.size());
		
		for(WebElement list: ele)
		{
			String url=list.getAttribute("href");
			//To add all links in Array List
			hrefs.add(list.getAttribute("href"));
			
			//To get text of all links
			String link_text=list.getText();
			System.out.println("Link texts are: "+link_text);
			System.out.println("Links are: "+url);
			
			//list.click();
			//driver.navigate().back();
		}
		
		int i=0;
		for(String href: hrefs)
		{
			   driver.navigate().to(href);
			   System.out.println((++i)+": navigated to URL with href: "+href);
		       Thread.sleep(3000); // To check if the navigation is happening properly.
		       System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}
		
	
	
		
	}
}
