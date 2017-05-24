package com.example.v_zakudong.jniopencv;

/**
 * Created by v_zakudong on 2017/5/11.
 */

public class OpenCvHelper {
    static {
        System.loadLibrary("ImgFun");
    }
    public static native int[] ImgFun(int[] buf,int w,int h);
}
