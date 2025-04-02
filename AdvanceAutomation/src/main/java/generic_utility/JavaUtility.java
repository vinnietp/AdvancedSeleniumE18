package generic_utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNo(int limit)
	{
		Random ran=new Random();
		int randomNum=ran.nextInt(limit);
		
		return randomNum;
		
	}

	public String generateSystemDate(int days)
	{
		Date dateObj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-YYYY");
		String todaysDate=sim.format(dateObj);
		return todaysDate;
	}
	public String generteReqDate(int days)
	{
		Date dateObj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat();
		String todaysDate=sim.format(dateObj);
		
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String closeDate=sim.format(cal.getTime());
		return closeDate;
		
	}
}
