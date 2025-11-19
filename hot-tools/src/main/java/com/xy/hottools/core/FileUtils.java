package com.xy.hottools.core;

import com.xy.hottools.LogUtil;

import java.io.File;

/**
 * 文件类型工具类
 *
 * @author Mr.xie
 * @apiNote v1
 */
public class FileUtils {


    private final static String FILE_END_SEP = "/";

    /**
     * 创建一个文件 在指定目录下面
     *
     * @param fileName 文件名称
     * @param path     文件路径
     */
    public static boolean mkFile(String fileName, String path) {
        try {
            String completePath = path.endsWith(FILE_END_SEP) ? path + fileName : path + "/" + fileName;
            File file = new File(completePath);
            if (file.exists()) {
                LogUtil.i("fileName %s 已经存在, completePath : %s", fileName, completePath);
                return false;
            }
            return true;
        } catch (Exception e) {
            LogUtil.i("fileName %s 创建失败,reason : %s, ", fileName, e.getMessage());
            return false;
        }
    }


    /**
     * 移动文件
     *
     * @param fromPath 源文件地址
     * @param toPath   目标地址
     */
    public static boolean moveTo(String fromPath, String toPath) throws IllegalAccessException {
        throw new IllegalAccessException("暂未开放");
    }


    /**
     * 拷贝文件
     *
     * @param fromPath 源文件地址
     * @param toPath   目标地址
     */
    public static boolean copyFile(String fromPath, String toPath) throws IllegalAccessException {
        throw new IllegalAccessException("暂未开放");
    }
}
