package com.daiyuma.tmp.year2020.month09.day22;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    private static final String DATE_FORMATTER = "yyyyMMdd";

    private static final String TIME_FORMATTER = "HHmmss";


    public static String getDate(){
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ofPattern(DATE_FORMATTER).format(now);
    }

    public static String getTime(){
        LocalDateTime now = LocalDateTime.now();
        return DateTimeFormatter.ofPattern(TIME_FORMATTER).format(now);
    }
}
