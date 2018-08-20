package com.utils;

import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.ValueRange;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
import static java.time.temporal.ChronoField.SECOND_OF_MINUTE;

/**
 * 时间工具类
 *
 * Date
 *
 * LocalDate
 * LocalTime
 * LocalDateTime
 *
 * Instant
 * TimeUnit
 * Temporal
 * TemporalAccessor
 * TemporalField
 * TemporalUnit
 * TemporalAmount
 *
 * Duration
 *
 */
public class DateUtils {

    /**
     * 计算两个时间的天数差
     */
    public static int duration(Date d1, Date d2, TimeUnit timeUnit){

        LocalDate ld1 = toLocalDate(d1);
        LocalDate ld2 = toLocalDate(d2);
//        Duration.between(d1.toInstant().adjustInto(Temporal))
        return 0;
    }




    public static Date dayBegin(Date date){

        LocalDateTime localDateTime = toLocalDateTime(date);
        localDateTime = localDateTime.with(HOUR_OF_DAY, localDateTime.range(HOUR_OF_DAY).getMinimum())
                    .with(MINUTE_OF_HOUR, localDateTime.range(MINUTE_OF_HOUR).getMinimum())
                    .with(SECOND_OF_MINUTE, localDateTime.range(SECOND_OF_MINUTE).getMinimum());
        return toDate(localDateTime);
    }

    public static Date dayEnd(Date date){
        LocalDateTime localDateTime = toLocalDateTime(date);
//        localDateTime = localDateTime
        return null;
    }

    public static void main(String[] args) {
        System.out.println(dayBegin(new Date()));
    }

    private static LocalDateTime customDay(LocalDateTime dateTime, boolean maxHour, boolean maxMinute, boolean maxSecond){
        if( null == dateTime) dateTime = LocalDateTime.now();
//        dateTime.with(HOUR_OF_DAY, maxHour ? dateTime.range(HOUR_OF_DAY).getMaximum())
        return null;
    }

    private static LocalDate toLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    private static LocalDateTime toLocalDateTime(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    private static LocalTime toLocalTime(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    private static Date toDate(LocalDateTime localDateTime){
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


}
