package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sliderimages 
{
	
		public static void main(String[] args) 
		{
	
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			List<WebElement> total_slider = driver.findElements(By.xpath("//div[@class='aqWyJi']//a"));
			System.out.println("Total no of slider images are: "+total_slider.size());
			for(WebElement list: total_slider)
			{
				System.out.println(list.getAttribute("href"));
			}
	}	
	

}