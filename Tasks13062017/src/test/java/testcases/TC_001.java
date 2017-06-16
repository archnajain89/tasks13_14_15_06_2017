package testcases;
import org.testng.annotations.Test;
import base.CreateDriver;
import pages.CheckboxRadiobtn;
import pages.HandleWebTables;



public class TC_001 extends CreateDriver
{
	
	/*@Test(priority=1)
	public void test1() throws InterruptedException
	{
		System.out.println("SUCESSSSSSSSSSSSS");
		HandleWebTables lp=new HandleWebTables(driver);
		lp.handleWebTable();
	}*/
	
	@Test(priority=1)
	public void test1() throws InterruptedException
	{
		System.out.println("SUCESSSSSSSSSSSSS");
		CheckboxRadiobtn lp=new CheckboxRadiobtn(driver);
		lp.chkradio();
	}
	
	
		
}
