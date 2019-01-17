package com.xjh.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public  class WorkflowDateUtil {

	/**
	 * 获取本年第一天
	 * @return
	 */
	public static String getYeasFirst(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-");

		// 获取上个月的第一天
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		String firstDay = format.format(cal_1.getTime())+"01-01";
		return firstDay;
	}
	/**
	 * 获取本年最后一天
	 * @return
	 */

	public static String getYeasLast(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-");
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		String firstDay = format.format(cal_1.getTime())+"12-31";
		return firstDay;
	}

	/**
	 * 获取当前月第一天
	 * @return
	 */
	public static String getMonthFirst(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar   cal_1=Calendar.getInstance();//获取当前日期
		cal_1.add(Calendar.MONTH, 0);
		cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
		String firstDay = format.format(cal_1.getTime());

		return firstDay;
	}
	/**
	 * 获取当前月第最后一天
	 * @return
	 */
	public static String getMonthLast(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());

		return last;
	}
	/**
	 * 获取当前日期
	 * @return
	 */
	public static String getDate(){
		Calendar c=java.util.Calendar.getInstance();
		SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd");
		String getdate = f.format(c.getTime());
		return getdate;
	}

	public static double getTime(String date ,String time,String enddate , String endtime){

		double returnValue=0.0;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		DecimalFormat df1=new DecimalFormat(".##");
		try
		{
			Date d1 = df.parse(date+" "+time);
			Date d2 = df.parse(enddate+" "+endtime);
			double diff = d2.getTime() - d1.getTime();
			double days = diff / (1000 * 60 * 60);
			String st=df1.format(days);
			returnValue = Double.parseDouble(st);
		}
		catch (Exception e)
		{
			return returnValue;
		}

		return returnValue;

	}
	/**
	 * 获取两个日期之间有多少天
	 * @param begin
	 * @param end
	 * @return
	 */
	public static List<Date> getBetweenDates(String date, String enddate) {
		List<Date> result = new ArrayList<Date>();
		Calendar tempStart = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date begin = df.parse(date);
			Date end = df.parse(enddate);
			tempStart.setTime(begin);
			while (begin.getTime() <= end.getTime()) {
				result.add(tempStart.getTime());
				tempStart.add(Calendar.DAY_OF_YEAR, 1);
				begin = tempStart.getTime();
			}
		} catch (ParseException e) {
			result=null;
		}
		return result;
	}
}
