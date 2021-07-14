package edu.bjtu.oldcare.oldback.util;

import edu.bjtu.oldcare.oldback.entity.DayCompare;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {


    public static Date checkDate(String origin) {
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        Date result = null;

        try {
            result = fmt.parse(origin);
        } catch (ParseException e) {
            return null;
        }

        return result;
    }

    /**
     * 计算2个日期之间相差的  相差多少年月日
     * 比如：2011-02-02 到  2017-03-02 相差 6年，1个月，0天
     * @param fromDate
     * @param toDate
     * @return
     */
    public static DayCompare dayComparePrecise(Date fromDate,Date toDate){
        Calendar from  =  Calendar.getInstance();
        from.setTime(fromDate);
        Calendar  to  =  Calendar.getInstance();
        to.setTime(toDate);

        int fromYear = from.get(Calendar.YEAR);
        int fromMonth = from.get(Calendar.MONTH);
        int fromDay = from.get(Calendar.DAY_OF_MONTH);

        int toYear = to.get(Calendar.YEAR);
        int toMonth = to.get(Calendar.MONTH);
        int toDay = to.get(Calendar.DAY_OF_MONTH);
        int year = toYear  -  fromYear;
        int month = toMonth  - fromMonth;
        int day = toDay  - fromDay;
        return DayCompare.builder().day(day).month(month).year(year).build();
    }

    /**
     * 计算2个日期相差多少年
     * 列：2011-02-02  ~  2017-03-02 大约相差 6.1 年
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int yearCompare(Date fromDate,Date toDate){
        DayCompare result = dayComparePrecise(fromDate, toDate);
//        double month = result.getMonth();
        int year = result.getYear();
        //返回2位小数，并且四舍五入
//        DecimalFormat df = new DecimalFormat("######0.0");
        return year;
    }
}
