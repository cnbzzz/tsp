package cn.spacewalker.tsp.bg.tbox.util;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by steven ma
 * 2017/8/23 11:36
 */

public class TimeFormatUtil {

    private Logger log = LogManager.getLogger(this.getClass().getName());
    
    //时间格式
    private static final String patterns = "yy MM dd HH mm ss";

    //yy MM dd HH mm ss 日期格式的转化
    public static String tboxDate2Str(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat(patterns);
        return sdf.format(date);
    }

    //yy MM dd HH mm ss 日期格式的转化
    public static Date tboxStr2Date(String time) {
        try {
            Date dTime = DateUtils.parseDate(time, patterns);
            //log.info("time:" + dTime);

            return dTime;

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String addTimeBySec(String gatherTime, int inSec) {

        Date dTime = tboxStr2Date(gatherTime);

        dTime = DateUtils.addSeconds(dTime, inSec);

        return TimeFormatUtil.tboxDate2Str(dTime);
    }

    //yyyy-MM-dd HH:mm:ss 日期格式的转化
    public static  String formatDate(Date date)throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    //yyyy-MM-dd HH:mm:ss 日期格式的转化
    public static Date parse(String strDate) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(strDate);
    }

//    public static void runByDate(String begin, String end) throws ParseException {
//        String parsePatterns = "yyyy-MM-dd HH:mm:ss";
//        Date beginDate = DateUtils.parseDate(begin, parsePatterns);
//        Date endDate = DateUtils.parseDate(end, parsePatterns);
//        Date currDate = beginDate;
//
//        //当“当前时间”早于结束时间
//        while (currDate.compareTo(endDate) < 0) {
//            //dosomething
//
//            log.info("date:" + currDate );
//            //当前时间往后移动
//            currDate = DateUtils.addSeconds(currDate, 5);
//
//        }
//    }

    public static void main(String[] args) {

//        int max=20000;
//        int min=10;
//        Random random = new Random();

        for(int i = 0; i < 20; i++) {
            //log.info("{}" ,(Long)(Math.random() * 10000));
            //log.info(random.nextInt(max) %(max-min+1) + min);
        }

//        String begin = "2017-08-23 00:00:00";
//        String end = "2017-08-23 00:01:00";
//        try {
//            runByDate(begin, end);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        Date date = new Date();
//        String strdate = tboxDate2Str(date);
//
//        log.info("date:" + date + "str:" + strdate);
//
//        Date newdate = DateUtils.addSeconds(date, 5);
//        strdate = tboxDate2Str(newdate);
//        log.info("date:" + newdate + "str:" + strdate);
//
//
//        Date enddate = DateUtils.addMinutes(date, 1);
//        //距离enddate每5S执行一次
//        while (enddate.compareTo(newdate) > 0) {
//            newdate = DateUtils.addSeconds(newdate, 5);
//            log.info("enddate:" + enddate +
//                    "date:" + newdate);
//        }

    }

}
