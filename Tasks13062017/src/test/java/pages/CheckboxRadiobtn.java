package pages;

import java.util.List;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxRadiobtn 
{
	ResourceBundle rb;
	WebDriver driver;
	
	public CheckboxRadiobtn(WebDriver driver)
	{
		this.driver=driver;
		rb=ResourceBundle.getBundle("Element");
	}
	
	public void chkradio() throws InterruptedException
	{
		boolean cvalue=false;
		boolean rvalue=false;
		
		List<WebElement> chkboxes=driver.findElements(By.name("color"));
		List<WebElement> radiobtn=driver.findElements(By.name("browser"));
		
		int Checkbox_size=chkboxes.size();
		int radiobtn_size=radiobtn.size();
		
		System.out.println("Total no. of checkboxes: "+Checkbox_size);
		System.out.println("Total no. of radio buttons: "+radiobtn_size);
		
		//To select check boxes..
		try
		{
			
		for(int i=0;i <Checkbox_size;i++)
			{
			cvalue=chkboxes.get(i).isSelected();
			System.out.println("check box no "+ i+" & check box is selected"+cvalue);
			
			//to select even check boxes
			int div=(i+1)%2;
			System.out.println(div);
			if(cvalue==false && div==0)
			{
				chkboxes.get(i).click();
			}
			
			Thread.sleep(1000);
			
			/*//to select odd check boxes
			int div1=(i)%2;
			System.out.println(div1);
			if(cvalue==false && div1==0)
			{
				chkboxes.get(i).click();
			}*/
			}
		}
		catch(Exception e)
		{	}
		
		//To select radio button......
		try
		{
			for(int j=0;j <radiobtn_size;j++)
		{
	
		rvalue=radiobtn.get(j).isSelected();
		System.out.println("Radio button no "+ j+" & radio button is selected"+rvalue);
		
		//to select even radio boxes
		int div3=(j+1)%2;
		System.out.println(div3);
		if(rvalue==false && div3==0)
		{
			radiobtn.get(j).click();
		}
		
		
		Thread.sleep(500);
				
		}
	}
	catch(Exception e)
	{
		
	}		
	}
}
