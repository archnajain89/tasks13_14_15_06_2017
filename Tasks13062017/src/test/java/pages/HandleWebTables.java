package pages;
import java.util.List;
import java.util.ResourceBundle;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;



public class HandleWebTables 
{
	ResourceBundle rb;
	WebDriver driver;
	
	public HandleWebTables(WebDriver driver)
	{
		this.driver=driver;
		rb=ResourceBundle.getBundle("Element");
	}
	
	public void handleWebTable() throws InterruptedException
	{
		
		//To locate table.
		WebElement mytable = driver.findElement(By.xpath("//div[@class='post-body entry-content']//following::tbody"));

		//To locate rows of table. 
		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));
		
		//To calculate no of rows In table.
		int rows_count = rows_table.size();
		
		System.out.println("Total No. of rows "+rows_count);
		
		//Loop will execute till the last row of table.
		for (int row=0; row<rows_count; row++)
		{ 
		//To locate columns(cells) of that specific row.
		List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td")); 
			
		//To calculate no of columns (cells). In that specific row.
		int columns_count = Columns_row.size();

		System.out.println("Number of cells In Row "+row+" are "+columns_count);

		//Loop will execute till the last cell of that specific row.
		for (int column=0; column<columns_count; column++)
		{ 
		// To retrieve text from that specific cell.
		String celtext = Columns_row.get(column).getText();
		System.out.println("Cell Value of row number "+row+" and column number "+column+" Is "+celtext);
		}
		System.out.println("------------------------------------- ");
		}
	}	
}
