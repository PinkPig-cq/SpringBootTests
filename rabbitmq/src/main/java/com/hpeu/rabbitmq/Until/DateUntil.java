package com.hpeu.rabbitmq.Until;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUntil {
    public static String toDate(long dateLong) {
        Date date = new Date(dateLong);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 24h:mm:ss");
        return simpleDateFormat.format(date);
    }
}
