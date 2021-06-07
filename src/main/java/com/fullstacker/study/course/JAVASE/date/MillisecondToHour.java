package com.fullstacker.study.course.JAVASE.date;

import java.util.Date;

/**
 * 毫秒转成时分秒格式
 *
 * @author xingguishuai
 * @create 2018-09-21-15:20
 **/
public class MillisecondToHour {


    public static void main(String[] args) {
                /*
                    错误代码 ms值超过24小时时错误
                    long ms = 300000;
                    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
                    formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
                    String hms = formatter.format(ms);
                    System.out.println(hms);*/

        MillisecondToHour millisecondToHour = new MillisecondToHour();
        String s = millisecondToHour.formatDuring(100000);

        System.out.println(s);


    }

    /**
             *
     * @param mss 要转换的毫秒数
     * @return 该毫秒数转换为 * days * hours * minutes * seconds 后的格式
     * @author fy.zhang
     */
    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        return days + " days " + hours + " hours " + minutes + " minutes "
                + seconds + " seconds ";
    }

    /**
             *
     * @param begin 时间段的开始
     * @param end   时间段的结束
     * @return 输入的两个Date类型数据之间的时间间格用* days * hours * minutes * seconds的格式展示
     * @author fy.zhang
     */
    public static String formatDuring(Date begin, Date end) {
        return formatDuring(end.getTime() - begin.getTime());
    }


}
