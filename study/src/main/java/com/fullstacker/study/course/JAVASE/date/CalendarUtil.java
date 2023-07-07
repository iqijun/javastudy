package com.fullstacker.study.course.JAVASE.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @author xgs
 * @create 2017-07-27-17:55
 **/
public class CalendarUtil {
    
    private static String getWeekScope(Integer weekOfYear) {
        String str = String.valueOf(weekOfYear);
        String strWeek = str.substring(4);
        String strYear = str.substring(0, 4);
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.YEAR, Integer.valueOf(strYear));
        calendar.set(Calendar.WEEK_OF_YEAR, Integer.valueOf(strWeek));
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date monday = calendar.getTime();
        String monStr = DateUtil.dateToStr(monday, "M/d");
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date sunDay = calendar.getTime();
        String sunStr = DateUtil.dateToStr(sunDay, "M/d");
        return monStr + "-" + sunStr;
        
    }
    
    public static void main(String[] args) {
        getWeekScope(201722);
    }
}
