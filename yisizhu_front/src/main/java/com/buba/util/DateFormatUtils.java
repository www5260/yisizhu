package com.buba.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtils {

	static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

	static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 格式化日期，将date类型转为String
	 * 格式：yyyy-MM-dd
	 * @return String
	 */
	public static String formatDate(Date date) {
		String strDate = sdf1.format(date);
		return strDate;
	}

	/**
	 * 格式化日期，将String转为Date类型的
	 * 格式：yyyy-MM-dd
	 * @return Date
	 */
	public static Date formatDate(String strDate) {
		Date date = null;
		try {
			date = sdf1.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 格式化日期，将String转为Date类型的
	 * 格式：yyyy-MM-dd
	 * @return Date
	 */
	public static Date formatDate1(String strDate) {
		Date date = null;
		try {
			date = sdf2.parse(strDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取当前系统日期，
	 * 格式：yyyy-MM-dd
	 * @return Date
	 */
	public static Date getCurrentDate() {
		Date date = new Date();
		String sysDate = sdf1.format(date);
		return formatDate(sysDate);
	}

	/**
	 * 获取当前系统日期，
	 * 格式：yyyy-MM-dd HH:mm:ss
	 * @return Date
	 */
	public static Date getCurrentDate1() {
		Date date = new Date();
		String sysDate = sdf2.format(date);
		return formatDate1(sysDate);
	}

	/**
	 * 获取当前系统日期
	 * 格式：yyyy-MM-dd
	 * @return String
	 */
	public static String getStrCurrentDate() {
		Date date = new Date();
		return formatDate(date);
	}

	/**
	 * 日期比较
	 * 返回int类型，返回1：date1早，返回-1：date2早，返回0时间一样
	 * @param date1 与当前日起要比较的日期
	 * @param date2 当前日期
	 */
	public static int checkTime(Date date1, Date date2) {
		if (date1.getTime() > date2.getTime()) {
			return -1;
		} else if (date1.getTime() < date2.getTime()) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * 获取当前系统日期 yyyy-MM-dd HH:mm:ss
	 */
	public static String currentDate() {
		Date date = new Date();
		String sysDate = sdf2.format(date);
		return sysDate;
	}

	/**
	 * 获取三个月后的日期
	 */
	public static Date afterThirdMonth() {
		Date date = getCurrentDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, 90);
		date = cal.getTime();
		String stringDate = sdf1.format(date);
		return formatDate(stringDate);
	}
	
	/**
	 * 获取第二天日期字符串
	 * 参数Date 返回String
	 */
	public static String getStrNextDate(Date date) {
		String str = "";
		Calendar cal = Calendar.getInstance();//获取日历类对象
		cal.setTime(date);// 设置为当前时间
		cal.add(Calendar.DATE, 1);//对日 进行操作，加一天
		date = cal.getTime();// 获取日历类中的时间
		str = sdf1.format(date);// 转换为String类型
		return str;
	}
	
	/**
	 * 获取第二天日期 Date
	 * 参数String 返回Date
	 */
	public static Date getNextDate(String strDate) {
		Date date = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(formatDate(strDate));
		cal.add(Calendar.DATE, 1);
		date = cal.getTime();
		return date;
	}

	/**
	 * 获取第二天日期 Date
	 * 参数Date 返回指定类型的格式（yyyy-MM-dd）date类型
	 */
	public static Date getNextDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		date = cal.getTime();
		return formatDate(date,"yyyy-MM-dd");
	}

	/**
	 *  计算当月最后一天,返回字符串
	 *  通过日历类Calendar
	 * @return String
	 */
	public static String getLastDayOfMonth() {
		String str = "";
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
		str = sdf1.format(lastDate.getTime());
		return str;
	}

	/**
	 *  获取当月第一天
	 * @return String
	 */
	public static String getFirstDayOfMonth() {
		String str = "";
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		str = sdf1.format(lastDate.getTime());
		return str;
	}

	/**
	 *  获取当天时间
	 * @return String
	 */
	public static String getNowTimeString() {
		return sdf1.format(new Date());
	}

	/**
	 * 格式化日期，将字符串改变格式后输出,两种格式都不同返回null
	 * 将1995:10:03 转为1995-10-03
	 * @param dateStr
	 * @return String
	 */
	public static String getFormatDate(String dateStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String date = format.format(sdf.parse(dateStr));
			return date;
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * 进行日期格式的转换，第二个参数pattern可以为null，为null则有默认的格式
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String getDate(Date date, String formatStr) {
		return getFormatDate(date, formatStr);
	}
	/**
	 * 进行日期格式的转换，第二个参数pattern可以为null，为null则有默认的格式
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getFormatDate(Date date, String pattern) { 
		if (pattern == null || pattern.length() < 1) {
			pattern = "yyyy-MM-dd";
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			String strDate = sdf.format(date);
			return strDate;
		} catch (Exception e) {
			System.out.println("日期格转换失败！");
		}
		return null;
	}

	/**
	 * 将date类型按照指定得格式进行格式化
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date formatDate(Date date, String pattern){
		try {
			return sdf1.parse(sdf1.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
			return date;
		}
	}
}
