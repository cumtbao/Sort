package com.shang;

/**
 * Created by shang on 2018/2/21.
 */
public class QuickSort {

    public void quickSort(int[] a) {
        quickSort0(a, 0, a.length - 1);
    }
    private void quickSort0(int[] a, int low, int high) {
        if (low < high) {
            int pos = partition(a, low, high);
            quickSort0(a, low, pos - 1);
            quickSort0(a, pos + 1, high);
        }
    }
    private int partition(int[] a, int low, int high) {
        int privotKey = a[low];
        while (low < high) {
            while (low < high && a[high] >= privotKey) {
                high--;
            }
            CommonUtils.swap(a, low, high);
            while (low < high && a[low] <= privotKey) {
                low++;
            }
            CommonUtils.swap(a, low, high);
        }
        return low;
    }


}
