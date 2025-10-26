package com.xy.hottools.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import com.xy.hottools.LogUtil;

/**
 * 线程执行器工具类
 *
 * @author Mr.xie
 * @apiNote V1
 */
public class ExecutorUtils {


    private static Handler asyncThread = null;

    private static Handler mainThread = null;
    private static final Handler MAIN = new Handler(Looper.getMainLooper());
    private static volatile Handler BACKGROUND;

    public static Handler IO() {
        return MAIN;
    }

    public static Handler BACKGROUND() {
        if (BACKGROUND == null) {
            synchronized (ExecutorUtils.class) {
                if (BACKGROUND == null) {
                    HandlerThread ht = new HandlerThread("ExecutorUtils");
                    ht.start();
                    BACKGROUND = new Handler(ht.getLooper());
                }
            }
        }
        return BACKGROUND;
    }


    /**
     * 初始化函数
     */
    public static void init() {
        LogUtil.i("hot-tools-android executor init .... ");
        asyncThread = BACKGROUND();
        mainThread = IO();
    }

    /**
     * 执行异步线程
     *
     * @param runnable 可执行对象
     */
    public static void execBackground(Runnable runnable) {
        asyncThread.post(runnable);
    }


    /**
     * 执行主线程
     *
     * @param runnable 可执行对象
     */
    public static void execMain(Runnable runnable) {
        mainThread.post(runnable);
    }


    /**
     * 延时执行异步线程
     *
     * @param runnable 可执行对象
     * @param ts       延时多久 毫秒
     */
    public static void execBackgroundDelay(Runnable runnable, long ts) {
        asyncThread.postDelayed(runnable, ts);
    }

    /**
     * 延时执行主线程
     *
     * @param runnable 可执行对象
     * @param ts       延时多久 毫秒
     */
    public static void execMainDelay(Runnable runnable, long ts) {
        mainThread.postDelayed(runnable, ts);
    }


    /**
     * 在其他线程中执行1s任务
     *
     * @param runnable 执行的任务
     */
    public static void delayBackground1s(Runnable runnable) {
        asyncThread.postDelayed(runnable, 1000L);
    }


    /**
     * 在主线程鸿执行1s任务
     *
     * @param runnable 需要执行的任务
     */
    public static void delayMain1s(Runnable runnable) {
        mainThread.postDelayed(runnable, 1000L);
    }


    /**
     * 在指定时间执行某个任务 主线程
     *
     * @param runnable 执行的任务
     * @param ts       时间 毫秒
     */
    public static void ExecMainAtTime(Runnable runnable, long ts) {
        mainThread.postAtTime(runnable, ts);
    }


    /**
     * 在指定时间执行某个任务 异步线程
     *
     * @param runnable 执行的任务
     * @param ts       时间 毫秒
     */
    public static void ExecBackgroundAtTime(Runnable runnable, long ts) {
        asyncThread.postAtTime(runnable, ts);
    }


}
