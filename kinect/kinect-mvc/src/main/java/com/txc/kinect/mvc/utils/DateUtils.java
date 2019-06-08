package com.txc.kinect.mvc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static Date parse(String dateStr) throws ParseException {
		return new SimpleDateFormat(DATE_FORMAT).parse(dateStr);
	}

	public static String format(Date date){
		if(date == null){
			throw new IllegalArgumentException("date must be not null.");
		}else{
			return new SimpleDateFormat(DATE_FORMAT).format(date);
		}
	}
}
