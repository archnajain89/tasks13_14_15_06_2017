package pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavascriptBorder 
{
	public static void main(String[] args) throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*try
		{*/
		//highlight element using javascript
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//Thread.sleep(5000);
		
		//Xpath for search element
		WebElement ele=driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));

		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		//Call execute script method
		js.executeScript("arguments[0].style.backgroundColor = 'red'", ele);
		/*}
		
		catch(Exception e)
		{
			e.getMessage();
		}
*/
	}
}
