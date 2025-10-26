package com.xy.hottools.core;


import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

/**
 * 图片处理相关的工具类
 *
 * @author Mr.xie
 * @apiNote V1
 */
public class ImageUtils {

    /**
     * 重置图片
     */
    public static void resetImageView(ImageView imageView, @DrawableRes int resId) {
        imageView.setImageBitmap(null);
        imageView.setImageDrawable(null);
        imageView.setBackgroundResource(resId);
    }

    /**
     * 重置图片
     */
    public static void resetImageView(ImageView imageView, @NonNull Drawable drawable) {
        imageView.setImageBitmap(null);
        imageView.setImageDrawable(null);
        imageView.setBackground(drawable);
    }

    /**
     * 重置图片
     */
    public static void resetImageView(ImageView imageView, Uri uri) {
        imageView.setImageBitmap(null);
        imageView.setImageDrawable(null);
        imageView.setImageURI(uri);
    }


    /**
     * 把ImageView 裁剪指定大小
     *
     * @param imageView   imageView对象
     * @param leftTop     左上
     * @param rightTop    右上
     * @param leftBottom  左下
     * @param RightBottom 右下
     */
    public static void clipRound(ImageView imageView, int leftTop, int rightTop, int leftBottom, int RightBottom) {
        int width = imageView.getMeasuredWidth();
        int height = imageView.getMeasuredHeight();
        if (width == 0) width = imageView.getLayoutParams().width;
        if (height == 0) height = imageView.getLayoutParams().height;
        int finalWidth = width;
        int finalHeight = height;
        imageView.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                Path path = new Path();
                path.addRoundRect(0, 0, finalWidth, finalHeight, new float[]{
                        leftTop, leftTop,
                        rightTop, rightTop,
                        RightBottom, RightBottom,
                        leftBottom, leftBottom,
                }, Path.Direction.CW);
                outline.setConvexPath(path);
            }
        });
        imageView.setClipToOutline(true);
    }


    /**
     * imageView 设置为圆角
     *
     * @param imageView imageview对象
     * @param radius    圆角
     */
    public static void clipRound(ImageView imageView, float radius) {
        imageView.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
            }
        });
        imageView.setClipToOutline(true);
    }


}
