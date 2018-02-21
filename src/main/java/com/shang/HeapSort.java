package com.shang;

import java.util.Arrays;

/**
 * Created by shang on 2018/2/21.
 */
public class HeapSort {

    public void heapSort(int[] a) {
        buildingHeap(a, a.length);
        for (int i = a.length - 1; i > 0; i--) {
            CommonUtils.swap(a, i, 0);
            adjustHeap(a, 0, i);
            System.out.println(Arrays.toString(a));
        }
    }
    /**
     * 选择排序-堆排序
     *
     * 若以一维数组存储一个堆，则堆对应一个完全二叉树，且所有非叶结点的值，不大于其子女的值
     * 堆顶元素是最小的（小顶堆）
     *
     *
     * 已知a[s...m]除了a[s]外均满足堆的定义 调整a[s]，使之成为大顶堆，将第s个结点为根的子树筛选
     *
     * a：待调整的堆数组 s：待调整的数组元素的位置 length：数组长度
     */
    private void adjustHeap(int[] a, int s, int length) {
        int tmp = a[s];
        int child = 2 * s + 1; // 左孩子结点位置
        while (child < length) {
            // 如果有右孩子，同时右孩子值 > 左孩子值
            if (child + 1 < length && a[child] < a[child + 1])
                child++;
            if (a[s] < a[child]) { // 较大的子结点>父节点
                a[s] = a[child]; // 替换父节点
                s = child; // 重新设置，待调整的下一个结点位置
                child = 2 * s + 1;
            } else
                break;
            a[s] = tmp; // 交换
        }
    }
    /**
     * 初始堆进行调整 将a[0...length-1]建成堆
     * 调整完后，第一个元素是序列最小的元素
     */
    private void buildingHeap(int[] a, int length) {
        // 最有一个有孩子结点的位置是 i = (length - 1) / 2
        for (int i = (length - 1) / 2; i >= 0; i--) {
            adjustHeap(a, i, length);
        }
    }


}
