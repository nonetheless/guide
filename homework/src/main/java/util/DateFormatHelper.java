package util;

import java.text.DateFormat;
import java.util.Date;

public class DateFormatHelper {

	public static String getCurrentTime() {
		String time="";
		Date date=new Date();
		time=DateFormat.getDateInstance().format(date);
		return time;
	}
}
