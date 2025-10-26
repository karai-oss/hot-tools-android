package com.xy.hottools.core;

import android.annotation.SuppressLint;
import android.util.Log;

import com.xy.hottools.LogUtil;
import com.xy.hottools.constant.DateType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class DateUtils {


    private static final Calendar calendar = Calendar.getInstance();

    /**
     * 格式化日期对象
     *
     * @param dateType hot-tool 预设选项
     * @param date     日期对象
     * @return 格式化以后得日期字符串
     */
    private static String format(DateType dateType, Date date) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat(dateType.format);
        return sdf.format(date);
    }


    /**
     * 格式化日期对象
     *
     * @param dateType 格式化字符串 用户指定
     * @param date     日期对象
     * @return 格式化以后得日期字符串
     */
    private static String format(String dateType, Date date) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat(dateType);
        return sdf.format(date);
    }




    private static long getTime(String dateStr) {
        java.text.DateFormat dateInstance = SimpleDateFormat.getDateInstance();
        try {
            return Objects.requireNonNull(dateInstance.parse(dateStr)).getTime();
        } catch (ParseException e) {
            return -1;
        }
    }
}
