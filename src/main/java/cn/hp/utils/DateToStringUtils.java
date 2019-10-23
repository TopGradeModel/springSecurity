package cn.hp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToStringUtils {
	public static String DateToString(Date date) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		return str;
		
	}

}
