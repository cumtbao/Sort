package com.shang;

/**
 * Created by shang on 2018/2/21.
 * 冒泡排序：每次循环，将最后一个位置排序好
 * 算法改进：加一个标志位，记录每次排序的位置，下一次只需要扫描到pos位置即可
 *
 */
public class BubbleSorted {

    public void bubbleSort(int[] a){

        if(a==null){
            return ;
        }

        int right = a.length -1;
        while (right>0){
            int pos =0;
            for (int start = 0; start < right; start++) {

                if(a[start] > a[start+1]){
                    CommonUtils.swap(a,start,start+1);
                    pos = start;
                }
            }
            right = pos;
        }
    }
}
