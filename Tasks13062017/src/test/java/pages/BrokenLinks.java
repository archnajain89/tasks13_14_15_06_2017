package pages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrokenLinks
{
  int row_count = 0;
  int column_count = 0;
  
  
  public static void main(String[] args)
  {
	  BrokenLinks brokenLinks = new BrokenLinks();
	  
	  try {
		brokenLinks.HandleLinks();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  private static boolean getResponseCode(String uRL) {
		// TODO Auto-generated method stub

		boolean validResponse = false;

		try {

			HttpResponse urlresp = new DefaultHttpClient().execute(new HttpGet(uRL));
			int resp_code = urlresp.getStatusLine().getStatusCode();

			System.out.println("Responce code = " + resp_code);

			if (resp_code == 404) {
				validResponse = false;
			} else {
				validResponse = true;
			}
		} catch (Exception e) {

			validResponse = true;
		}
		return validResponse;

	}
   
  
  
  
  @Test
  public void HandleLinks()
    throws MalformedURLException, Exception
  {
	  System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
    System.out.println("Test Links");
    WebDriver driver = new ChromeDriver();
    System.out.println("All the Best");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5L, TimeUnit.MINUTES);
    
    System.out.println("Tools.QA");
    
    driver.get("http://google.com");
    
    List<WebElement> Linkset1 = driver.findElements(By.tagName("a"));
    
    Linkset1.addAll(driver.findElements(By.tagName("img")));
    
    List<WebElement> finalList = new ArrayList();
    for (WebElement item : Linkset1) {
      if (item.getAttribute("href") != null) {
        finalList.add(item);
      }
    }
    System.out.println("Total number of links are " + finalList.size());
    for (WebElement item : finalList) {
      try
      {
        URL url = new URL(item.getAttribute("href"));
        String response = "";
        
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        
        connection.setConnectTimeout(10000);
        
        connection.connect();
        if (connection.getResponseCode() == 200)
        {
          response = connection.getResponseMessage();
          System.out.println(response);
          
          List<WebElement> total_links = driver.findElements(By.tagName("a"));
          
          int cell_count0 = 0;
          
          
        /*  File f = new File("D:\\brokenlinktest.xls");
  		FileOutputStream fout = new FileOutputStream(f);
  		XSSFWorkbook wk = new XSSFWorkbook();
  		XSSFSheet s1 = wk.createSheet("Sheet1");

  		for (int i = 0; i < total_links.size(); i++) {
  			String URL = total_links.get(i).getAttribute("href");
  			if (URL != null) {
  				isvalid = getResponseCode(URL);
  				if (isvalid) {

  					for (WebElement url : total_links) {
  						String s = url.getAttribute("href");
  						s1.createRow(row_count++).createCell(cell_count0).setCellValue(s);
  					}
  					wk.write(fout);
  					wk.close();

  					System.out.println("Valid Link:" + URL);

  				}

  				// Save in Excel sheet
  				else {

  					System.out.println("Broken Link ------> " + URL);
  				}
  			} else {
  				System.out.println("Broken Link..." + URL);
  			}

  		}*/
          
          boolean isvalid = false;
  		 File f = new File("D:\\book123.xls");
  		FileOutputStream fout = new FileOutputStream(f);
  		XSSFWorkbook book = new XSSFWorkbook();
  		XSSFSheet s1 = book.createSheet("Sheet1");
  		for (int i = 0; i < total_links.size(); i++) {
  			String URL = total_links.get(i).getAttribute("href");
  			if (URL != null) {
  				isvalid = getResponseCode(URL);
  				if (isvalid) {

  					for (WebElement url1 : total_links) {
  						String s = url1.getAttribute("href");
  						s1.createRow(row_count++).createCell(cell_count0).setCellValue(s);
  					}
  					book.write(fout);
  					book.close();

  					System.out.println("Valid Link:" + URL);

  				}

  				// Save in Excel sheet
  				else {

  					System.out.println("Broken Link ------> " + URL);
  				}
  			} else {
  				System.out.println("Broken Link..." + URL);
  			}

  		}
  		
         /* XSSFWorkbook book = new XSSFWorkbook();
          
          XSSFSheet sheet = book.getSheet("Sheet1");
          
          sheet.createRow(this.row_count++).createCell(this.column_count).setCellValue(response);
          
          FileOutputStream file = new FileOutputStream("D:\\Book1.xlsx");
          
          book.write(file);*/
        }
        else
        {
          System.out.println(url);
        }
      }
      catch (Exception localException) {}
 
      
    }
  }
}
