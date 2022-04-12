package com.ksprogramming;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUtil {
    public static LocalDateTime convertToLocalDateTime(java.sql.Date date) {
       return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
