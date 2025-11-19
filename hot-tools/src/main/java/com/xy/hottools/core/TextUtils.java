package com.xy.hottools.core;


/**
 * 文本工具类
 *
 * @author Mr.xie
 * @apiNote v1
 */
public class TextUtils {


    public static String isEmptySendText(String text, String defaultText) {
        return StringUtils.isEmpty(text) ? defaultText : text;
    }

    public static String isEmptyEndDotRt(String text, String defaultText, int len) {
        return StringUtils.isEmpty(text) ? defaultText :
                (text.length() > len ? text.substring(0, len) + "..." : text);
    }


}
