package com.zdjy.bigdata.logistic_warehouse.crawlerNews.people.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期解析类
 * @author ylm
 *
 */
public class DateUtils {
	private static final SimpleDateFormat SIMPLEDATEFORMAT=new SimpleDateFormat("yyyy/MM/dd HH:mm");
	public static Date getDate(String dateString){
		try {
			return SIMPLEDATEFORMAT.parse(Calendar.getInstance().get(Calendar.YEAR)+"/"+dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
