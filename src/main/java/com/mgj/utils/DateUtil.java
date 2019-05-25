package com.mgj.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String parseDateTime()
    {
      String nowTime = ((new java.sql.Timestamp(System.currentTimeMillis())).toString()).substring(0, 19);
      try
      {
        int nowHour = Integer.parseInt(nowTime.substring(11, 13));
        if (nowHour <= 6)
        {
          SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
          Calendar c = Calendar.getInstance(); // 当时的日期和时间

          int d = c.get(Calendar.DAY_OF_MONTH); // 取出“日”数
          --d; // 将“日”减一，即得到前一天
          c.set(Calendar.DAY_OF_MONTH, d); // 将“日”数设置回去
          String parseDate = df.format(c.getTime());
          nowTime = parseDate + " 23:59:59";
        }
      }
      catch (Exception e)
      {
        e.printStackTrace();
        return ((new java.sql.Timestamp(System.currentTimeMillis())).toString()).substring(0, 19);
      }
      return nowTime;
    }

	public static String string2long(Long tt, String pattern) {
		Date date = new Date(tt);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
    
    
	/**
	 * 获得当前日期和时间
	 *
	 * @return String 当前日期和时间，格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String getCurTime()
	{
		SimpleDateFormat nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return nowDate.format(new Date());
	}
    
    
    /**
     * 格式化日期
     * @param date
     * @param pattern
     * @return
     */
    public static String regix(Date date, String pattern){
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    	return sdf.format(date);
    }
   
}
