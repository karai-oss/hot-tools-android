package com.xy.hottools;

import android.annotation.SuppressLint;

import com.xy.hottools.constant.DateType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DateUtils {


    private static String format(DateType dateType, Date date) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat(dateType.format);
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
