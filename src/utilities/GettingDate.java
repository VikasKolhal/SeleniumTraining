package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GettingDate {

	public static void main(String[] args) {
		//date class will get you the current system date
		Date d1=new Date();
		System.out.println("Actual date with formatting:"+d1);
		//SimpleDateFormat will help to get date in specific format
		SimpleDateFormat s=new SimpleDateFormat("dd/MMM/yyyy");
		//with the help of SimpleDateFormat you can convert your date into required format
		System.out.println("date with required format:"+s.format(d1));
		System.out.println("***********************");
		
		System.out.println(getSystemDate("dd-MM-yyyy"));
	}
     static	String getSystemDate(String formatForDate) {
		//date class will get you the current system date
		Date d1=new Date();
		//SimpleDateFormat will help to get date in specific format
		SimpleDateFormat s=new SimpleDateFormat(formatForDate);
		return s.format(d1);
	}

}
