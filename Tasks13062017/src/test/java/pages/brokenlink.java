package pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenlink 
{
	
		//To start Browser
		public static void main(String[] args) throws Exception
		{
			WebDriver driver;
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			List<WebElement> total_links = driver.findElements(By.tagName("a"));
			System.out.println("Total no of link found on page " + total_links.size());
			
			boolean isvalid = false;
			int row_count=0;
			int cell_count0=0;

			//To create excel file
			
			File f=new File("D:\\brokenlinktest.xls");
			FileOutputStream fout=new FileOutputStream(f);
			XSSFWorkbook wk=new XSSFWorkbook();
			XSSFSheet s1=wk.createSheet("Sheet1");
			
			
			for (int i = 0; i < total_links.size(); i++) {
			String URL = total_links.get(i).getAttribute("href");
			if (URL != null) 
			{
				isvalid = getResponseCode(URL);
				if (isvalid) 
				{
								
						for(WebElement url : total_links)
						{
						String s = url.getAttribute("href");
						s1.createRow(row_count++).createCell(cell_count0).setCellValue(s);
						}
						wk.write(fout);
						wk.close(); 
							
						System.out.println("Valid Link:" + URL);

					} 
					
					//Save in Excel sheet
					else 
					{
						
						System.out.println("Broken Link ------> " + URL);
					}
				} 
				else 
				{
					System.out.println("Broken Link..." + URL);
				}

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
			
			
			
		}	

