package com.shang;

/**
 * Created by shang on 2018/2/21.
 */
public class SelectSort {

    /**
     * 选择排序-简单选择排序
     * 基本思想：在一组要排序的数中，选取最小的与第一个位置交换
     */
    public void selectSort(int[] a) {
        for(int start = 0; start < a.length; start++) {
            int key = selectMinKey(a, start);
            CommonUtils.swap(a, key, start);
        }
    }
    private int selectMinKey(int[] a, int start) {
        int key = start;
        for(int i = start; i < a.length; i++) {
            key = a[key] > a[i] ? i : key;
        }
        return key;
    }


}
