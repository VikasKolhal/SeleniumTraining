package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GettingDate2 {

	public static void main(String[] args) {
		// get calender class onstance
     Calendar cal= Calendar.getInstance();
     //add number of  days(+/-) based on requirement
     cal.add(Calendar.DATE,10);
     //date class will get you the current system date
     Date d1=new Date(cal.getTimeInMillis());
   //SimpleDateFormat will help to get date in specific format
   		SimpleDateFormat s=new SimpleDateFormat("dd/MMM/yyyy");
   	//with the help of SimpleDateFormat you can convert your date into required format
   			System.out.println("date with required format:"+s.format(d1));
   			System.out.println("***********************");
   			System.out.println(getSystemDate("dd-MM-yyyy",7));
	}
   		  static String getSystemDate(String formatForDate,int days) {
   			Calendar cal= Calendar.getInstance();
   		    cal.add(Calendar.DATE,days);
   		 Date d1=new Date(cal.getTimeInMillis());
   		SimpleDateFormat s=new SimpleDateFormat("dd/MMM/yyyy");
   		return s.format(d1);
	}

}
