package com.shang;


import java.util.Arrays;

/**
 * A Camel Application
 */
public class SortedTest {

    public static void main(String[] args) {

        int[] a = {1,4,6,2,3,8};

        BubbleSorted bubbleSorted = new BubbleSorted();
        bubbleSorted.bubbleSort(a);

        System.out.println(Arrays.toString(a));
    }

}

