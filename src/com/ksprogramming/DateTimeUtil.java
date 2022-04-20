package com.ksprogramming;

import java.sql.SQLData;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUtil {
    public static LocalDateTime convertToLocalDateTime(java.sql.Date date) {
       return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    public static Timestamp convertToSqlDateTime(LocalDateTime time){
        return java.sql.Timestamp.valueOf(time);
    }

    public static java.sql.Date convertToLocalDate(LocalDate localDate){
        return java.sql.Date.valueOf(localDate);
    }
}
