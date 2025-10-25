package com.xy.hottools.core;


import java.util.Random;
import java.util.UUID;

/**
 * 字符串工具类
 *
 * @author Mr.xie
 * @apiNote v1
 */
public class StringUtils {


    private static final Random RANDOM = new Random();

    /**
     * 判断字符串是否为null
     *
     * @param o 校验字符串
     * @return true 为null false 不为null
     */
    public static boolean isNull(String o) {
        return o == null;
    }


    /**
     * 判断字符串是否为空字符串
     *
     * @param o 校验字符串
     * @return true 为空字符串 false 不为空字符串
     */
    public static boolean isEmpty(String o) {
        return "".equals(o);
    }


    /**
     * 判断字符串是否为null或者为空串
     *
     * @param o 校验字符串
     */
    public static boolean isNull2(String o) {
        return o == null || "".equals(o);
    }


    /**
     * 在指定字符串穿后面拼接省略号
     *
     * @param o   字符串
     * @param len 指定多长不用拼接
     * @return 处理之后的字符串
     */
    public static String endEllipsis(String o, int len) {
        if (o == null || "".equals(o) || o.length() < len) {
            return o;
        }
        return o.substring(0, len) + "...";
    }

    /**
     * 在指定字符串穿后面拼接指定的符号
     *
     * @param o      字符串
     * @param len    指定多长不用拼接
     * @param suffix 指定后缀
     * @return 处理之后的字符串
     */
    public static String endEllipsisBySign(String o, int len, String suffix) {
        if (o == null || "".equals(o) || o.length() < len) {
            return o;
        }
        return o.substring(0, len) + suffix;
    }


    /**
     * 字符串拼接
     *
     * @param str 多参数字符串
     */
    public static String concat(String... str) {
        if (str.length == 0) return "";
        String ret = str[0];
        for (int i = 1; i < str.length; i++) {
            ret += str[i];
        }

        return ret;
    }


    /**
     * 生成一个唯一ID
     */
    public static String uniqueId() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 15);
    }


    /**
     * 生成一个20个字符的唯一ID字符串
     */
    public static String uniqueId20() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 15);
    }

    public boolean isHttps(String o) {
        return o != null && o.startsWith("https");
    }


    public boolean isHttp(String o) {
        return o != null && o.startsWith("http");
    }
}
