package com.clps.bj.mms.common.util.data;





import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;



/**
* author ygg
* verson 1.0
* createTime  2017年12月11日下午8:09:31
* UpdateTime  2017年12月12日下午4:00:00
***/
public class MyDate {
	
	private  Calendar calendar;
	private final   String AMERICANDATELOCATION = "GMT-5:00";   //美国时区常量
	private final   String CHINESEDATELOCATION = "GMT+8:00";    //中国时区常量
	private final   String ENGLISHDATELOCATION = "GMT0:00";     //英国时区常量
	private  TimeZone tz = null;                                //时区timezone对象
	private  SimpleDateFormat sdft;                             //简单类型转换器
	public final  String myFormat = "yyyy-MM-dd ahh:mm:ss";     //转换器格式器
	
	
	{
		calendar = Calendar.getInstance();
		
	}
	
	
	
	/**
	 * 获取当前日期date格式
	 * @return date 当前时间
	 */
	public  Date getNowDate() throws ParseException {
		
		Date date  = calendar.getTime();
		return date;
	}

	/**
	 * 获取时区的timezone对象
	 * @return date 指定时区的时间
	 */
	public  TimeZone getTimeZone(Country c){
		tz = TimeZone.getTimeZone("GMT-5:00");
		switch(c){
			case ENGLISH:
				tz = TimeZone.getTimeZone(ENGLISHDATELOCATION);
				break;
			case CHINA:
				tz = TimeZone.getTimeZone(CHINESEDATELOCATION);
				break;
			case AMERICAN:
				tz = TimeZone.getTimeZone(AMERICANDATELOCATION);
				break;
		
		}
		return tz;
	}
	
	/**
	 * 根据指定地区获取时间的date类型
	 * @param date 要转换的date
	 * @return date转换后的String
	 */
	public  Date getPlaceDate(Country c) throws ParseException {
		
		
		TimeZone tz = getTimeZone(c);
		Calendar calendar = Calendar.getInstance(tz);
		Date d = calendar.getTime();
		return d;
	}

	/**
	 * 将date转换为String
	 * @param string 要转换的string
	 * @return 转换后的date
	 */
	public  String dateToString(Date date,String format) {
		sdft = new SimpleDateFormat(format);
		return sdft.format(date);
	}

	/**
	 * 获取当前时间的date类型 
	 * @return string
	 */
	public  Date StringToDate(String string,String format) throws ParseException {
		sdft = new SimpleDateFormat(format);
		return sdft.parse(string);
	}

	/**
	 * 获取当前时间的string类型
	 * @return  当前指定时区的时间
	 */
	public  String getNowStr() {
		
		Date date  = calendar.getTime();
		
		sdft = new SimpleDateFormat(myFormat,Locale.ENGLISH);
		String str = sdft.format(date);
		return str;
	}
	
	/**
	 * 获取当前时间的string类型
	 * @return  当前指定时区的时间
	 */
	public  String getNowStr(String myFormat) {
		
		Date date  = calendar.getTime();
		
		sdft = new SimpleDateFormat(myFormat,Locale.ENGLISH);
		String str = sdft.format(date);
		return str;
	}
	
	/**
	 * 通过system.currentMilis()获取date类型
	 * @return  当前指定时区的时间
	 */
	public  Date syscur(){
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 获取输入时区的date类型的str
	 * @return  当前指定时区的时间
	 */
	public  String getPlaceDateStr(Country c) {
		
		tz = getTimeZone(c);
		sdft = new SimpleDateFormat(myFormat,Locale.ENGLISH);
		sdft.setTimeZone(tz);
		String res = sdft.format(new Date());
		return res;
	}
	
	
	
	
}
