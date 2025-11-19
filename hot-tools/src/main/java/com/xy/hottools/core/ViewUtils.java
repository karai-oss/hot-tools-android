package com.xy.hottools.core;

import static androidx.constraintlayout.widget.ConstraintSet.VISIBLE;

import android.view.View;

/**
 * View工具类
 *
 * @author Mr.xie
 * @apiNote V1
 */
public class ViewUtils {

    /**
     * View可见
     *
     * @param views 多个view
     */
    public static void visible(View... views) {
        for (View v : views) {
            v.setVisibility(View.VISIBLE);
        }
    }

    /**
     * View不可见
     *
     * @param views 多个view
     */
    public static void hide(View... views) {
        for (View v : views) {
            v.setVisibility(View.GONE);
        }
    }

    /**
     * 显示/隐藏View
     *
     * @param visibleView 需要显示的View
     * @param hideView    需要隐藏的View
     */
    public static void visibility(View visibleView, View hideView) {
        if (visibleView == null) return;
        if (hideView == null) return;
        visibleView.setVisibility(View.VISIBLE);
        hideView.setVisibility(View.GONE);
    }

    public static void changeVisibility(View... views) {
        views[0].setVisibility(View.VISIBLE);
        views[1].setVisibility(View.GONE);
    }
}
