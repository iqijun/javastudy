package com.fullstacker.study.course.JAVASE.date;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {
    public static final String YYYYMMDD = "yyyy-MM-dd";
    public static final String HHMMSS = "HH:mm:ss";
    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final Long SECONDS_IN_MINUTE = Long.valueOf(60L);
    public static final Long MINUTES_IN_HOUR = Long.valueOf(60L);
    public static final Long HOURS_IN_DAY = Long.valueOf(24L);
    public static final Long DAYS_IN_WEEK = Long.valueOf(7L);
    public static final Long DAYS_IN_YEAR = Long.valueOf(365L);
    public static final Long DAYS_IN_MONTH = Long.valueOf(30L);
    public static final Long SECONDS_IN_YEAR;
    public static final Long SECONDS_IN_MONTH;
    public static final Long SECONDS_IN_WEEK;
    public static final int SECONDS_IN_DAY;
    public static final long SECONDS_IN_HOUR;
    public static final long MILLISECONDS_IN_SECOND = 1000L;
    public static final long MILLISECONDS_IN_MINUTE;
    public static final long MILLISECONDS_IN_HOUR;
    public static final long MILLISECONDS_IN_DAY;
    public static final long MILLISECONDS_IN_WEEK;

    private DateUtil() {
    }

    public static String getQueryDateFrom(String date) {
        return date + " 00:00:00";
    }

    public static String getQueryDateTill(String date) {
        return date + " 23:59:59";
    }

    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp getTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    public static int getThisYear() {
        Calendar calendarNow = Calendar.getInstance();
        return calendarNow.get(1);
    }

    public static String todayDateStr() {
        return showDate(new Date());
    }

    public static String minutesToHours(Integer minutes) {
        double ret = (double)(minutes.intValue() / 60);
        ret += (double)(minutes.intValue() % 60) / 60.0D;
        DecimalFormat df = new DecimalFormat("###.0");
        return df.format(ret);
    }

    public static String tommorowDateStr() {
        Date tommorow = addDay(new Date(), 1);
        return showDate(tommorow);
    }

    public static String showDate(Date date) {
        return dateToStr(date, "yyyy-MM-dd");
    }

    public static String showTime(Date date) {
        return dateToStr(date, "HH:mm:ss");
    }

    public static String showDateTime(Date date) {
        return dateToStr(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String dateToStr(Date date, String format) {
        if(date == null) {
            return "";
        } else {
            SimpleDateFormat dateToStr = new SimpleDateFormat(format);
            return dateToStr.format(date);
        }
    }

    public static Date strToDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        try {
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException var5) {
            var5.printStackTrace();
            return null;
        }
    }

    public static Date strToDate(String dateStr) {
        if(dateStr != null && dateStr.length() >= 8) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;

            try {
                date = df.parse(dateStr);
            } catch (ParseException var4) {
                ;
            }

            return date;
        } else {
            return null;
        }
    }

    public static Date strToTime(String timeStr) {
        if(timeStr != null && timeStr.length() >= 8) {
            if(timeStr.length() < 12) {
                timeStr = timeStr + " 00:00:00";
            }

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = null;

            try {
                date = df.parse(timeStr);
            } catch (ParseException var4) {
                ;
            }

            return date;
        } else {
            return null;
        }
    }

    public static long daysLeftTo(String fromDateStr, String toDateStr) {
//        return StringUtils.isNotEmpty(fromDateStr) && StringUtils.isNotEmpty(toDateStr)?Long.parseLong(CalendarUtil.getTwoDay(toDateStr, fromDateStr)):0L;
        return  1L;
    }

    public static long daysLeftTo(Date fromDate, Date toDate) {
        return fromDate != null && toDate != null?(toDate.getTime() - fromDate.getTime()) / MILLISECONDS_IN_DAY:0L;
    }

    public static long minutesLeftTo(Date fromDate, Date toDate) {
        return fromDate != null && toDate != null?(toDate.getTime() - fromDate.getTime()) / MILLISECONDS_IN_MINUTE:0L;
    }

    public static Double daysLeftTo(Date toDate) {
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = d.format(new Date());
        Double days = Double.valueOf(0.0D);

        try {
            days = Double.valueOf(Long.valueOf(toDate.getTime() - d.parse(nowtime).getTime()).doubleValue() / (double)MILLISECONDS_IN_DAY);
        } catch (ParseException var5) {
            var5.getMessage();
        }

        return days;
    }

    public static Long calMinutesPassed(Date from) {
        return from == null?Long.valueOf(0L):Long.valueOf(((new Date()).getTime() - from.getTime()) / MILLISECONDS_IN_MINUTE);
    }

    public static int compDate(String s1, String s2) {
        int day = 0;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date e = sf.parse(s1);
            Date date2 = sf.parse(s2);
            day = (int)((date2.getTime() - e.getTime()) / MILLISECONDS_IN_DAY);
        } catch (Exception var6) {
            var6.getMessage();
        }

        return day;
    }

    public static long daysLeftTo(String compareDateStr) {
        return daysLeftTo(todayDateStr(), compareDateStr);
    }

    public static long daysAfter(String compareDateStr) {
        return -1L * daysLeftTo(compareDateStr);
    }

    public static boolean todayIsAfter(String compareDateStr) {
        return !todayIsBefore(compareDateStr);
    }

    public static boolean isAfter(String fromDateStr, String toDateStr) {
        return daysLeftTo(fromDateStr, toDateStr) <= 0L;
    }

    public static boolean todayIsBefore(String compareDateStr) {
        return daysLeftTo(compareDateStr) > 0L;
    }

    public static boolean isBefore(String fromDateStr, String toDateStr) {
        return !isAfter(fromDateStr, toDateStr);
    }

    public static boolean sameDay(String compareDateStr) {
        return daysLeftTo(compareDateStr) == 0L;
    }

    public static boolean isSameDay(String fromDateStr, String toDateStr) {
        return daysLeftTo(fromDateStr, toDateStr) == 0L;
    }

    public static Date addDay(Date date, int days) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(6, days);
        return cale.getTime();
    }

    public static Date addHour(Date date, int hours) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(11, hours);
        return cale.getTime();
    }

    public static Date addMinute(Date date, int minutes) {
        Calendar cale = Calendar.getInstance();
        cale.setTime(date);
        cale.add(12, minutes);
        return cale.getTime();
    }

    public static Timestamp getCurrentDayEnd() {
        Calendar c = Calendar.getInstance();
        Timestamp t = new Timestamp(System.currentTimeMillis());
        c.setTime(t);
        c.set(11, 23);
        c.set(12, 59);
        c.set(13, 59);
        c.set(14, 999);
        return new Timestamp(c.getTimeInMillis());
    }

    public static Timestamp parseTimestamp(String timeStr) {
        Date d = strToTime(timeStr);
        return d != null?new Timestamp(d.getTime()):null;
    }

    public static Timestamp getCurrentDayStart() {
        Calendar c = Calendar.getInstance();
        Timestamp t = new Timestamp(System.currentTimeMillis());
        c.setTime(t);
        c.set(11, 0);
        c.set(12, 0);
        c.set(13, 0);
        c.set(14, 0);
        return new Timestamp(c.getTimeInMillis());
    }

    public static Long minutesLeftTo(String date) {
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = d.format(new Date());
        Long minutes = Long.valueOf(0L);

        try {
            minutes = Long.valueOf(d.parse(nowtime).getTime() - d.parse(date).getTime());
            minutes = Long.valueOf(minutes.longValue() / MILLISECONDS_IN_MINUTE);
        } catch (ParseException var5) {
            var5.getMessage();
        }

        return minutes;
    }

    public static Long secondsLeftTo(String date) {
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = d.format(new Date());
        Long seconds = Long.valueOf(0L);

        try {
            seconds = Long.valueOf((d.parse(nowtime).getTime() - d.parse(date).getTime()) / 1000L);
        } catch (ParseException var5) {
            var5.getMessage();
        }

        return seconds;
    }

    static {
        SECONDS_IN_YEAR = Long.valueOf(SECONDS_IN_MINUTE.longValue() * MINUTES_IN_HOUR.longValue() * HOURS_IN_DAY.longValue() * DAYS_IN_YEAR.longValue());
        SECONDS_IN_MONTH = Long.valueOf(SECONDS_IN_MINUTE.longValue() * MINUTES_IN_HOUR.longValue() * HOURS_IN_DAY.longValue() * DAYS_IN_MONTH.longValue());
        SECONDS_IN_WEEK = Long.valueOf(SECONDS_IN_MINUTE.longValue() * MINUTES_IN_HOUR.longValue() * HOURS_IN_DAY.longValue() * DAYS_IN_WEEK.longValue());
        SECONDS_IN_DAY = SECONDS_IN_MINUTE.intValue() * MINUTES_IN_HOUR.intValue() * HOURS_IN_DAY.intValue();
        SECONDS_IN_HOUR = SECONDS_IN_MINUTE.longValue() * MINUTES_IN_HOUR.longValue();
        MILLISECONDS_IN_MINUTE = SECONDS_IN_MINUTE.longValue() * 1000L;
        MILLISECONDS_IN_HOUR = MINUTES_IN_HOUR.longValue() * MILLISECONDS_IN_MINUTE;
        MILLISECONDS_IN_DAY = HOURS_IN_DAY.longValue() * MILLISECONDS_IN_HOUR;
        MILLISECONDS_IN_WEEK = DAYS_IN_WEEK.longValue() * MILLISECONDS_IN_DAY;
    }
    /**
     * 根据时间获取年周次（该时间所在的周是本年度的第几个星期）
     * @return 格式：201730
     */
    public static Integer getWeekOfYear(Date date){

        Calendar c=Calendar.getInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(Calendar.MONDAY);//设置一周的第一天是星期一
        int year = c.get(Calendar.YEAR);
        int weekOfYear = c.get(Calendar.WEEK_OF_YEAR);
        DecimalFormat df=new DecimalFormat("00");
        String str2=df.format(weekOfYear);
        return Integer.parseInt(year+""+str2);
    }


    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = dateFormat.parse("2016-01-01");
        Integer startweekOfYear = getWeekOfYear(start);
        System.out.println(startweekOfYear);
        Date end = dateFormat.parse("2018-01-01");
         Integer endweekOfYear = getWeekOfYear(end);
        System.out.println(endweekOfYear);
    }
}
