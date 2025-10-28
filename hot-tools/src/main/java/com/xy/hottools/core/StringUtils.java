package com.xy.hottools.core;


import java.io.File;
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


    /**
     * 判断字符串URI 是否是https
     *
     * @param o 字符串
     */
    public static boolean isHttps(String o) {
        return o != null && o.startsWith("https");
    }


    /**
     * 判断字符串URL 是否是http
     *
     * @param o 字符串
     */
    public static boolean isHttp(String o) {
        return o != null && o.startsWith("http");
    }


    /**
     * 判断字符串中是否包括空白字符
     *
     * @param o 字符串
     */
    public static boolean isContainsWhitespace(String o) {
        if (o == null || o.isEmpty()) {
            return false;
        }

        for (int i = 0; i < o.length(); i++) {
            char c = o.charAt(i);
            if (Character.isWhitespace(c)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 去掉字符串中所有的 空字符
     *
     * @param o 字符串
     */
    public static String removeAllWhiteSpace(String o) {
        if (o == null || o.isEmpty()) {
            return "";
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < o.length(); i++) {
            char c = o.charAt(i);
            if (c == ' ') {
                continue;
            }
            ret.append(c);
        }

        return ret.toString();
    }


    /**
     * 忽略大小写 匹配字符串是否是以 指定字符串开头
     *
     * @param str    需要检测的字符串
     * @param prefix 指定的开头字符串
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        return (str != null && prefix != null && str.length() >= prefix.length() && str.regionMatches(true, 0, prefix, 0, prefix.length()));
    }


    /**
     * 忽略大小写 匹配字符串是否是以 指定字符串结尾
     *
     * @param str    需要检测的字符串
     * @param suffix 指定的结尾字符串
     */
    public static boolean endsWithIgnoreCase(String str, String suffix) {
        return (str != null && suffix != null && str.length() >= suffix.length() && str.regionMatches(true, str.length() - suffix.length(), suffix, 0, suffix.length()));
    }


    /**
     * 给指定字符串添加一个指定的前缀 并且返回这个添加之后字符串
     *
     * @param o      原始字符串 输入字符串
     * @param prefix 指定的前缀字符串
     */
    public static String addPrefix(String o, String prefix) {
        if (isNull2(o) || isNull2(prefix)) {
            return o;
        }
        return prefix + o;
    }


    /**
     * 给指定字符串添加一个指定的后缀 并且返回这个添加之后字符串
     *
     * @param o      原始字符串 输入字符串
     * @param suffix 指定的后缀字符串
     */
    public static String addSuffix(String o, String suffix) {
        if (isNull2(o) || isNull2(suffix)) {
            return o;
        }
        return o + suffix;
    }


    /**
     * 获取文件后缀名称
     *
     * @param file 文件
     */
    public static String fileSuffix(File file) {
        if (file == null) return "";
        String path = file.getPath();

        int lastDotIndex = path.lastIndexOf(".");
        if (lastDotIndex == -1) return "";
        return lastDotIndex + 1 > path.length() ? "" : path.substring(lastDotIndex + 1);
    }


    /**
     * 给字符串添加双引号
     *
     * @param o 字符串
     */
    public static String quotation(String o) {
        return '"' + o + '"';
    }

    /**
     * 给字符串添加单引号
     *
     * @param o 字符串
     */
    public static String singleQuotation(String o) {
        return "'" + o + "'";
    }

}


