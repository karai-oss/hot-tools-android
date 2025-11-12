package com.xy.hottools.core;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import java.util.Map;
import java.util.function.BiConsumer;

/**
 * 页面跳转工具类
 *
 * @author Mr.xie
 * @apiNote v1
 */
public class SkipUtils {

    /**
     * 普通调整页面 activity类型
     *
     * @param activity activity对象
     * @param cls      调整的页面类对象
     */
    public static void forwardPage(Activity activity, Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
    }


    /**
     * 普通调整页面 context类型
     *
     * @param context context对象
     * @param cls     调整的页面类对象
     */
    public static void forwardPage(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    public static void forwardPage(Context context, Class<?> cls, Map<String, String> params) {
        Intent intent = new Intent(context, cls);
        if (params != null && !params.isEmpty()) {
            params.forEach(new BiConsumer<String, String>() {
                @Override
                public void accept(String s, String s2) {
                    intent.putExtra(s, s2);
                }
            });
        }
        context.startActivity(intent);
    }


    /**
     * 调整到指定页面 多参数的模式 单数参数为key 偶数参数为值
     *
     * @param activity 上下文对下
     * @param cls      页面的类
     * @param params   参数
     */
    public static void forwardPage(Activity activity, Class<?> cls, String... params) {
        Intent intent = new Intent(activity, cls);
        if (params != null && params.length % 2 == 0) {
            for (int i = 0, j = i + 1; i < params.length && j < params.length; i += 2, j = i + 1) {
                String key = params[i];
                String value = params[j];
                intent.putExtra(key, value);
            }
        }
        activity.startActivity(intent);
    }


    /**
     * 调整到指定页面 多参数的模式 单数参数为key 偶数参数为值
     *
     * @param context 上下文对下
     * @param cls     页面的类
     * @param params  参数
     */
    public static void forwardPage(Context context, Class<?> cls, String... params) {
        Intent intent = new Intent(context, cls);
        if (params != null && params.length % 2 == 0) {
            for (int i = 0, j = i + 1; i < params.length && j < params.length; i += 2, j = i + 1) {
                String key = params[i];
                String value = params[j];
                intent.putExtra(key, value);
            }
        }
        context.startActivity(intent);
    }


    public static void forwardPage(Context context, String targetName, String... params) {
        ComponentName targetComponent = new ComponentName(context, context.getPackageName() + "." + targetName);
        Intent intent = new Intent();
        intent.setComponent(targetComponent);
        if (params != null && params.length % 2 == 0) {
            for (int i = 0, j = i + 1; i < params.length && j < params.length; i += 2, j = i + 1) {
                String key = params[i];
                String value = params[j];
                intent.putExtra(key, value);
            }
        }
        context.startActivity(intent);
    }


    public static void forwardPage(Activity activity, String targetName, String... params) {
        ComponentName targetComponent = new ComponentName(activity, activity.getPackageName() + "." + targetName);
        Intent intent = new Intent();
        intent.setComponent(targetComponent);
        if (params != null && params.length % 2 == 0) {
            for (int i = 0, j = i + 1; i < params.length && j < params.length; i += 2, j = i + 1) {
                String key = params[i];
                String value = params[j];
                intent.putExtra(key, value);
            }
        }
        activity.startActivity(intent);
    }


}
