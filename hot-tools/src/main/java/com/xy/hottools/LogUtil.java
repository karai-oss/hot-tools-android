package com.xy.hottools;


import android.text.TextUtils;
import android.util.Log;

import kotlin.internal.HidesMembers;

/**
 * 日志工具
 */

public class LogUtil {
    public enum Level {
        VERBOSE(Log.VERBOSE),
        DEBUG(Log.DEBUG),
        INFO(Log.INFO),
        WARN(Log.WARN),
        ERROR(Log.ERROR),
        ASSERT(Log.ASSERT);

        final int value;

        Level(int value) {
            this.value = value;
        }
    }

    /* ==========  外部可配置  ========== */
    private static boolean sEnabled   = true;                // 总开关
    private static Level   sMinLevel  = Level.VERBOSE;      // 最低输出级别
    private static String  sGlobalTag = "MyApp";            // 全局 TAG

    public static void setEnabled(boolean enabled) {
        sEnabled = enabled;
    }

    public static void setMinLevel(Level level) {
        sMinLevel = level;
    }

    public static void setGlobalTag(String tag) {
        sGlobalTag = tag;
    }



    /* ==========  对外 API  ========== */

    @HidesMembers
    public static void v(String msg, Object... args) {
        print(Level.VERBOSE, null, msg, args);
    }

    @HidesMembers
    public static void d(String msg, Object... args) {
        print(Level.DEBUG, null, msg, args);
    }

    @HidesMembers
    public static void i(String msg, Object... args) {
        print(Level.INFO, null, msg, args);
    }

    @HidesMembers
    public static void w(String msg, Object... args) {
        print(Level.WARN, null, msg, args);
    }

    @HidesMembers
    public static void w(Throwable tr, String msg, Object... args) {
        print(Level.WARN, tr, msg, args);
    }

    public static void e(String msg, Object... args) {
        print(Level.ERROR, null, msg, args);
    }

    public static void e(Throwable tr, String msg, Object... args) {
        print(Level.ERROR, tr, msg, args);
    }

    /* ==========  内部实现  ========== */
    private static void print(Level level, Throwable tr, String msg, Object... args) {
        if (!sEnabled || level.value < sMinLevel.value) return;

        final StackTraceElement caller = new Throwable().getStackTrace()[2];
        final String tag = buildTag(caller);
        final String message = buildMessage(caller, tr, msg, args);

        // 系统 Logcat
        logcat(level, tag, message);


    }

    private static String buildTag(StackTraceElement caller) {
        return TextUtils.isEmpty(sGlobalTag) ? caller.getFileName() : sGlobalTag;
    }

    private static String buildMessage(StackTraceElement caller, Throwable tr,
                                       String msg, Object... args) {
        StringBuilder sb = new StringBuilder();
        // 文件名:行号 方法名()
        sb.append('[')
                .append(caller.getFileName()).append(':').append(caller.getLineNumber())
                .append("  ")
                .append(caller.getMethodName()).append("()]  ");


        if (!TextUtils.isEmpty(msg)) {
            sb.append(args.length == 0 ? msg : String.format(msg, args));
        }

        // 异常堆栈
        if (tr != null) {
            sb.append("\n").append(Log.getStackTraceString(tr));
        }

        return sb.toString();
    }

    private static void logcat(Level level, String tag, String message) {
        final int len = 3000;
        int index = 0;
        int length = message.length();
        while (index < length) {
            int end = Math.min(index + len, length);
            String part = message.substring(index, end);
            switch (level) {
                case VERBOSE: Log.v(tag, part); break;
                case DEBUG:   Log.d(tag, part); break;
                case INFO:    Log.i(tag, part); break;
                case WARN:    Log.w(tag, part); break;
                case ERROR:   Log.e(tag, part); break;
                case ASSERT:  Log.wtf(tag, part); break;
            }
            index = end;
        }
    }
}
