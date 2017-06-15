package pages;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Sysdate
{
public static void main(String args[])
{

		// Create object of SimpleDateFormat class and decide the format
		 DateFormat dt_Format = new SimpleDateFormat("dd : MM : yyyy");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dt_Format.format(date);
		  
		 // Print the Date
		 String date_new=date1.replace(" ", "_");
		 String date_final=date_new.replace(":","_");
		 System.out.println("Current Date is :"+date_final);
}	
}