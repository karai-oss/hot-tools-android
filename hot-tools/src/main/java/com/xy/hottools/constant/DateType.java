package com.xy.hottools.constant;

public enum DateType {

    YYYY_DD_MM_HH_MM_SS("yyyy/MM/dd HH:mm:ss"),
    YYYY_MM_DD("yyyy/MM/dd"),
    YYYY_MM_DD_1("yyyy年MM月dd日"),
    YYYY_MM_DD_HH_MM_SS_1("yyyy年MM月dd日 HH:mm:ss");
    public String format = "yyyy年MM月dd日";

    DateType(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
