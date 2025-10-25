package com.xy.hottools.core;

import android.graphics.Color;

import java.util.Random;

public class ColorUtils {


    /**
     * 颜色随机数生成器
     */
    private final static Random COLOR = new Random();


    /**
     * S L 随机数生成器
     */
    private final static Random SL_RANDOM = new Random();


    /**
     * 生成亮色颜色
     */
    public static int lightColor() {
        float h = COLOR.nextInt(360);
        float s = 0.4f + SL_RANDOM.nextFloat() * 0.2f;
        float l = 0.7f + SL_RANDOM.nextFloat() * 0.25f;
        return hslToRgb(h, s, l);
    }


    /**
     * 生成暗色颜色
     */
    public static int dartColor() {
        float h = COLOR.nextInt(360);
        float s = 0.6f + SL_RANDOM.nextFloat() * 0.2f; // 0.6-0.8
        float l = 0.15f + SL_RANDOM.nextFloat() * 0.2f; // 0.15-0.35
        return hslToRgb(h, s, l);
    }


    /**
     * 随机生成两个亮色颜色
     */
    public static int[] light2Color() {
        int[] colors = new int[2];
        colors[0] = lightColor();
        colors[1] = lightColor();
        return colors;
    }


    /**
     * 随机生成两个暗色颜色
     */
    public static int[] dart2Color() {
        int[] colors = new int[2];
        colors[0] = dartColor();
        colors[1] = dartColor();
        return colors;
    }


    /**
     * 随机生成三个亮色颜色
     */
    public static int[] light3Color() {
        int[] colors = new int[4];
        colors[0] = lightColor();
        colors[1] = lightColor();
        colors[2] = lightColor();
        return colors;
    }


    /**
     * 随机生成三个暗色颜色
     */
    public static int[] dart3Color() {
        int[] colors = new int[3];
        colors[0] = dartColor();
        colors[1] = dartColor();
        colors[2] = dartColor();
        return colors;
    }


    private static int hslToRgb(float h, float s, float l) {
        float c = (1 - Math.abs(2 * l - 1)) * s;
        float x = c * (1 - Math.abs((h / 60) % 2 - 1));
        float m = l - c / 2;

        float r = 0, g = 0, b = 0;
        switch ((int) (h / 60)) {
            case 0:
                r = c;
                g = x;
                b = 0;
                break;
            case 1:
                r = x;
                g = c;
                b = 0;
                break;
            case 2:
                r = 0;
                g = c;
                b = x;
                break;
            case 3:
                r = 0;
                g = x;
                b = c;
                break;
            case 4:
                r = x;
                g = 0;
                b = c;
                break;
            case 5:
                r = c;
                g = 0;
                b = x;
                break;
        }
        r += m;
        g += m;
        b += m;
        return Color.rgb(r, g, b);
    }



}
