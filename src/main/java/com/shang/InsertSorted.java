package com.shang;

/**
 * Created by shang on 2018/2/21.
 * 直接插入排序，
 */
public class InsertSorted {

    public void insertSort(int[] a) {
        for (int right = 1; right < a.length; right++) {
            if (a[right] < a[right - 1]) {
                int tmp = a[right]; // 保存临时变量
                int left = right - 1;
                a[right] = a[right - 1]; // 先后移一个位置
                for (; left >= 0 && tmp < a[left]; left--) {
                    a[left + 1] = a[left];
                }
                a[left + 1] = tmp;// 插入到正确位置
            }
        }
    }


}
