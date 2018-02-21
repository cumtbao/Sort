package com.shang;

/**
 * Created by shang on 2018/2/21.
 */
public class MergeSort {

    public void mergeSort(int[] a) {
        mergeSort0(a, 0, a.length - 1);
    }
    private void mergeSort0(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort0(a, left, mid);
            mergeSort0(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }
    private void merge(int[] a, int start1, int mid, int right) {
        int[] tmp = new int[a.length];

        int k = start1; // tmp的初始下标
        int start = start1; // 记录初始位置
        int start2 = mid + 1; // 第2个数组的起始位置

        for(; start1 <= mid && start2 <= right; k++) {
            tmp[k] = a[start1] < a[start2] ? a[start1++] : a[start2++];
        }

        // 左边剩余的合并
        while (start1 <= mid) {
            tmp[k++] = a[start1++];
        }
        // 右边剩余的合并
        while (start2 <= right) {
            tmp[k++] = a[start2++];
        }

        // 复制数组
        while (start <= right) {
            a[start] = tmp[start];
            start++;
        }
    }


}
