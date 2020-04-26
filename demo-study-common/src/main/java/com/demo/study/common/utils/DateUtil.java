package com.demo.study.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 日期工具类
 * @author: Aaron Ma
 **/
public class DateUtil {

    private DateUtil() {};

    private static final String DATE_FORMAT_1="yyyy-MM-dd HH:mm:ss";

    public static String getDateFormatter(Date date){
        DateFormat dateFormat=new SimpleDateFormat();
        return dateFormat.format(date);
    }
}
