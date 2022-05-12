//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package lv.aaa.util;

import com.alibaba.fastjson.JSON;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
    public static final String LONG_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_FORMAT_STR = "yyyy-MM-dd";
    public static final String SHORT_DATE_PATTERN_4_SEARCH = "yyyyMMdd";
    public static final String DEFAULT_X_FORMAT_STR = "yyyy/MM/dd";
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String ZH_TO_DAY = "yyyy年MM月dd日";
    public static final String ZH_TO_MINUTE = "yyyy年MM月dd日 HH时mm分";
    public static final String ZH_TO_SECOND = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String YEAR_MONTH = "yyyy-MM";
    public static final String MONTH = "MM";
    public static final String YEARMOTH = "yyyyMM";
    public static final String YEAR = "yyyy";
    public static final String DAY = "dd";
    public static final String startTime_suffix = " 00:00:00";
    public static final String endTime_suffix = " 23:59:59";
    public static final String EN_GB_DATE_PATTERN = "dd/MM/yyyy";
    public static final String EN_GB_DATETIME_PATTERN = "dd/MM/yyyy HH:mm:ss";
    public static final String EN_GB_ZH_CN_DATE_PATTERN = "yyyy/MM/dd";
    public static final String EN_GB_ZH_CN_DATETIME_PATTERN = "yyyy/MM/dd HH:mm:ss";
    public static final String ZH_CN_DATE_PATTERN = "yyyy-MM-dd";
    public static final String ZH_CN_DATETIME_PATTERNSSS = "yyyy-MM-dd HH:mm:ss SSS";
    public static final String WITHOUTTIME_DATE_PATTERN = "yyyyMMdd";
    public static final String NOMARK_DATETIME_PATTERN = "yyyyMMddHHmmss";
    public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddhhmmssSSS";
    public static final String YYYY_NIAN_MM_YUE_DD_RI_HH_MM_SS = "yyyy年MM月dd日 HH:mm:ss";
    public static final String HH_mm_ss = "HH:mm:ss";
    public static final String HH_mm_ss_SSS = "HH:mm:ss SSS";
    public static final String INIT_DATE = "1970-1-1";
    public static final String ZERO_DATE_PATTERN = "yyyyMMdd000000";
    public static final String ZERO_DATE_HOUR_PATTERN = "yyyyMMddHH0000";
    private static final Object lockObj = new Object();
    private static Map<String, ThreadLocal<SimpleDateFormat>> threadLocalMap = new HashMap();

    public DateUtil() {
    }

    public static Date parseCnDate(String sDate) {
        return parseThread(sDate, "yyyyMMdd");
    }

    public static Date parseNomHmsDate(String sDate) {
        return parseThread(sDate, "yyyyMMddHHmmss");
    }

    public static Date parseCnZhDate(String sDate) {
        return parseThread(sDate, "yyyy-MM-dd");
    }

    public static Date parseCnHmsDate(String sDate) {
        return parseThread(sDate, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date parseEnDate(String sDate) {
        return parseThread(sDate, "yyyy/MM/dd");
    }

    public static Date parseEnHmsDate(String sDate) {
        return parseThread(sDate, "yyyy/MM/dd HH:mm:ss");
    }

    public static Date parseRiDate(String sDate) {
        return parseThread(sDate, "yyyy年MM月dd日");
    }

    public static Date parseRiHmsDate(String sDate) {
        return parseThread(sDate, "yyyy年MM月dd日 HH:mm:ss");
    }

    public static Date parseZeroDate(String sDate) {
        return parseThread(sDate, "yyyyMMdd000000");
    }

    public static String formatCnDate(Date sDate) {
        return formatThread(sDate, "yyyyMMdd");
    }

    public static String formatNomHmsDate(Date sDate) {
        return formatThread(sDate, "yyyyMMddHHmmss");
    }

    public static String formatCnZhDate(Date sDate) {
        return formatThread(sDate, "yyyy-MM-dd");
    }

    public static String formatCnHmsDate(Date sDate) {
        return formatThread(sDate, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatEnDate(Date sDate) {
        return formatThread(sDate, "yyyy/MM/dd");
    }

    public static String formatEnHmsDate(Date sDate) {
        return formatThread(sDate, "yyyy/MM/dd HH:mm:ss");
    }

    public static String formatRiDate(Date sDate) {
        return formatThread(sDate, "yyyy年MM月dd日");
    }

    public static String formatRiHmsDate(Date sDate) {
        return formatThread(sDate, "yyyy年MM月dd日 HH:mm:ss");
    }

    public static String formatZeroDate(Date sDate) {
        return formatThread(sDate, "yyyyMMdd000000");
    }

    private static SimpleDateFormat getThreadDateFormat(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = (ThreadLocal)threadLocalMap.get(pattern);
        if (tl == null) {
            synchronized(lockObj) {
                tl = (ThreadLocal)threadLocalMap.get(pattern);
                if (tl == null) {
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    threadLocalMap.put(pattern, tl);
                }
            }
        }

        return (SimpleDateFormat)tl.get();
    }

    public static String formatThread(Date date, String pattern) {
        return date == null ? null : getThreadDateFormat(pattern).format(date);
    }

    public static Date parseThread(String dateStr, String pattern) {
        if (StringUtils.isNotBlank(dateStr)) {
            try {
                return getThreadDateFormat(pattern).parse(dateStr);
            } catch (ParseException var3) {
                LOGGER.warn(var3.getMessage(), var3);
                return null;
            }
        } else {
            return null;
        }
    }

    public static String zhToDay(Date date) {
        SimpleDateFormat sfZhToDay = new SimpleDateFormat("yyyy年MM月dd日");
        return date == null ? "" : sfZhToDay.format(date);
    }

    public static Date dateToDay(String date) {
        Date result = null;
        SimpleDateFormat dateZhToDay = new SimpleDateFormat("yyyy-MM-dd");

        try {
            if (StringUtils.isNotBlank(date)) {
                result = dateZhToDay.parse(date);
            }
        } catch (ParseException var4) {
            LOGGER.warn(var4.getMessage(), var4);
        }

        return result;
    }

    public static String zhToMinute(Date date) {
        SimpleDateFormat sfZhToMinute = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        return date == null ? "" : sfZhToMinute.format(date);
    }

    public static int calcTodayEndSecond() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(11, 23);
        todayEnd.set(12, 59);
        todayEnd.set(13, 59);
        return (int)((todayEnd.getTime().getTime() - (new Date()).getTime()) / 1000L);
    }

    public static Long calcTodayStartSecond() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(11, 0);
        todayStart.set(12, 0);
        todayStart.set(13, 0);
        return ((new Date()).getTime() - todayStart.getTime().getTime()) / 1000L;
    }

    public static String longFormat(Date date) {
        return format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String shortFormat(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    public static String shortFormat4Search(Date date) {
        return format(date, "yyyyMMdd");
    }

    public static String format(Date date, String patern) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat sDateFormat = new SimpleDateFormat(patern);
            return sDateFormat.format(date);
        }
    }

    public static String getCurrentDate(String formatStr) {
        if (null == formatStr) {
            formatStr = "yyyy-MM-dd";
        }

        return date2String(new Date(), formatStr);
    }

    public static String date2String(Date date, String formatStr) {
        if (null == date) {
            return "";
        } else {
            if (formatStr == null) {
                formatStr = "yyyy-MM-dd";
            }

            DateFormat df = createFormatter(formatStr);
            return df.format(date);
        }
    }

    public static Date String2Date(String date) throws ParseException {
        DateFormat df = createFormatter("yyyy-MM-dd");
        return df.parse(date);
    }

    public static DateFormat createFormatter(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    public static String ymdFormat(Date date) {
        if (date == null) {
            return "";
        } else {
            DateFormat df = createFormatter("yyyy-MM-dd");
            return df.format(date);
        }
    }

    public static String ymdXFormat(Date date) {
        if (date == null) {
            return "";
        } else {
            DateFormat df = createFormatter("yyyy/MM/dd");
            return df.format(date);
        }
    }

    public static final String StringPattern(String date, String oldPattern, String newPattern) {
        if (date != null && oldPattern != null && newPattern != null) {
            SimpleDateFormat sdf1 = new SimpleDateFormat(oldPattern);
            SimpleDateFormat sdf2 = new SimpleDateFormat(newPattern);
            Date d = null;

            try {
                d = sdf1.parse(date);
            } catch (Exception var7) {
                LOGGER.warn(var7.getMessage(), var7);
            }

            return sdf2.format(d);
        } else {
            return "";
        }
    }

    public static String zhToSecond(Date date) {
        SimpleDateFormat shZhToSecond = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        return date == null ? "" : shZhToSecond.format(date);
    }

    public static Long calculateSeconds(Date oneDate, Date otherDate) {
        if (null != oneDate && null != otherDate) {
            try {
                return (oneDate.getTime() - otherDate.getTime()) / 1000L;
            } catch (Exception var3) {
                LOGGER.warn(var3.getMessage(), var3);
                return null;
            }
        } else {
            return null;
        }
    }

    public static Date calculateStartTime(Date startDate) {
        if (null == startDate) {
            startDate = new Date();
        }

        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            cal.add(5, 1);
            String newEffectDateStr = format(cal.getTime(), "yyyy-MM-dd") + " 00:00:00";
            return String2Date(newEffectDateStr, "yyyy-MM-dd HH:mm:ss");
        } catch (Exception var3) {
            LOGGER.debug(var3.getMessage(), var3);
            return null;
        }
    }

    public static Date calculateEndTime(Date startDate) {
        if (null == startDate) {
            return null;
        } else {
            try {
                Calendar cal = Calendar.getInstance();
                cal.setTime(startDate);
                cal.add(5, -1);
                cal.add(1, 1);
                String endDateStr = format(cal.getTime(), "yyyy-MM-dd") + " 23:59:59";
                return String2Date(endDateStr, "yyyy-MM-dd HH:mm:ss");
            } catch (Exception var3) {
                LOGGER.info(var3.getMessage(), var3);
                return null;
            }
        }
    }

    public static Long getDayToDateTime(Date stard, Date end) {
        if (!stard.before(end)) {
            return null;
        } else {
            long l = end.getTime() - stard.getTime();
            long day = l / 86400000L;
            long hour = l / 3600000L - day * 24L;
            long min = l / 60000L - day * 24L * 60L - hour * 60L;
            if (hour > 0L) {
                ++day;
            } else if (hour == 0L && min > 0L) {
                ++day;
            }

            return day;
        }
    }

    public static Date String2Date(String dateStr, String formatStr) {
        try {
            if (StringUtils.isBlank(dateStr)) {
                return null;
            } else {
                if (formatStr == null) {
                    formatStr = "yyyy-MM-dd";
                }

                DateFormat df = createFormatter(formatStr);
                return df.parse(dateStr);
            }
        } catch (Exception var3) {
            LOGGER.warn(var3.getMessage(), var3);
            return null;
        }
    }

    public static String getAgeSurfix(String surfix) {
        if (!surfix.endsWith("d") && !surfix.endsWith("D")) {
            return !surfix.endsWith("m") && !surfix.endsWith("M") ? "周岁" : "月";
        } else {
            return "天";
        }
    }

    public static Date addSeconds(Date date, int seconds) {
        if (date == null) {
            return null;
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(13, seconds);
            return c.getTime();
        }
    }

    public static Date addHours(Date date, int hours) {
        if (date == null) {
            return null;
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(10, hours);
            return c.getTime();
        }
    }

    public static Date addDays(Date date, int days) {
        if (date == null) {
            return null;
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(5, days);
            return c.getTime();
        }
    }

    public static Date addMonths(Date date, int months) {
        if (date == null) {
            return null;
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(2, months);
            return c.getTime();
        }
    }

    public static Date addYears(Date date, int years) {
        if (date == null) {
            return null;
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(1, years);
            return c.getTime();
        }
    }

    public static int getRelativeAge(Date relativeDate, Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(relativeDate);
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(birthDay);
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        } else {
            int age = caculateAge(cal, cal1);
            return age;
        }
    }

    private static int caculateAge(Calendar cal, Calendar cal1) {
        int yearNow = cal.get(1);
        int monthNow = cal.get(2);
        int dayOfMonthNow = cal.get(5);
        int yearBirth = cal1.get(1);
        int monthBirth = cal1.get(2);
        int dayOfMonthBirth = cal1.get(5);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) {
                    --age;
                }
            } else {
                --age;
            }
        }

        return age;
    }

    public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        Calendar cal1 = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        } else {
            cal1.setTime(birthDay);
            int age = caculateAge(cal, cal1);
            return age;
        }
    }

    public static Date parseCustomDate(String customDate) {
        if (StringUtils.isBlank(customDate)) {
            return null;
        } else {
            String[] formateArray = new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMdd", "yyyyMMdd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm:ss.SSS"};

            try {
                return DateUtils.parseDateStrictly(customDate, formateArray);
            } catch (Exception var3) {
                throw new RuntimeException("非合法日期字符串,目前支持  " + JSON.toJSONString(formateArray));
            }
        }
    }

    public static int calcDays(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance(TimeZone.getDefault());
        c1.setTime(date1);
        long t1 = c1.getTime().getTime();
        Calendar c2 = Calendar.getInstance(TimeZone.getDefault());
        c2.setTime(date2);
        long t2 = c2.getTime().getTime();
        return Math.abs((int)(t1 / 1000L - t2 / 1000L) / 3600 / 24);
    }

    public static int getSecond(Date d) {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());
        now.setTime(d);
        return now.get(13);
    }

    public static int getMin(Date d) {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());
        now.setTime(d);
        return now.get(12);
    }

    public static int getHour(Date d) {
        Calendar now = Calendar.getInstance(TimeZone.getDefault());
        now.setTime(d);
        return now.get(11);
    }

    public static boolean isValidDate(String sDate, String pattern) {
        if (StringUtils.isBlank(sDate)) {
            return false;
        } else {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                sdf.setLenient(false);
                sdf.parse(sDate);
                return true;
            } catch (Exception var3) {
                LOGGER.warn(var3.getMessage(), var3);
                return false;
            }
        }
    }

    public static boolean minuteAndSecondIsIntegral(Date date) {
        if (date == null) {
            return false;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int minute = calendar.get(12);
            int second = calendar.get(13);
            return minute == 0 && second == 0;
        }
    }

    /**
     * 获取上个最后一天的时分秒
     * @param date
     */
    public static void getUpMonthLastDayHms(Date date) {
        LocalDateTime expriyDate = LocalDateUtils.convertToLocalDateTime(date);
        expriyDate = expriyDate.plusMonths(-1);
        expriyDate = expriyDate.with(TemporalAdjusters.lastDayOfMonth());
        expriyDate = expriyDate.withHour(23);
        expriyDate = expriyDate.withMinute(59);
        expriyDate = expriyDate.withSecond(59);
        System.out.println(expriyDate.toString());
    }
}
