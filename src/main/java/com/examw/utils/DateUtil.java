package com.examw.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期工具类。
 * @author yangyong.
 * @since 2014-03-19.
 * */
public final class DateUtil {
	/**
	 * 取得指定日期所在周的第一天。
	 * @param date
	 * 	指定日期。
	 * @return
	 * 	所在周的第一天。
	 * */
	public static Date firstDayOfWeek(Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());//monday
		return calendar.getTime();
	}
	/**
	 * 取得指定日期所在周的最后一天。
	 * @param date
	 * 	指定日期。
	 * @return
	 * 	所在周的最后一天。
	 * */
	public static Date lastDayOfWeek(Date date){
		Calendar calendar = new GregorianCalendar();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6);//sunday
		return calendar.getTime();
	}
	/**
	 * 获取当前日期是星期几。
	 *  @param date
	 *   星期几。
	 * */
	public static int DayOfWeekValue(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	/**
	 * 获取当前日期是星期几。
	 *  @param date
	 *   星期几。
	 * */
	public static String DayOfWeekText(Date date){
		String[] weekTexts = {"", "日", "一", "二", "三", "四", "五", "六"};
		return  "星期" + weekTexts[DayOfWeekValue(date)];
	}
}