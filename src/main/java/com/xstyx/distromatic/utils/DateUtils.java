package com.xstyx.distromatic.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	//TODO: add pattern on properties
	private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
	
	public static String getDateString(LocalDateTime localDateTime){
		return localDateTime.format(formatter);
	}
	
	public static LocalDateTime getDateNow(){
		return LocalDateTime.now();
	}
	
	public static String getDateNowString(){
		return getDateString(getDateNow());
	}

}
