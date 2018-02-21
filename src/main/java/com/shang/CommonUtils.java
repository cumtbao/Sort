package com.shang;

/**
 * Created by shang on 2018/2/21.
 */
public class CommonUtils {

    public static void swap(int[] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
