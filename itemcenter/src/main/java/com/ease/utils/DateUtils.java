package com.ease.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String parseTime(Date date) {
        //将Date类型格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(date);
        return dateString;

    }
}
