package com.AlgorTest;

/**
 * Created by liuzhixiong on 2018/4/14.
 */
public class StringTest {

    public static int getCount(String max,String min){

        int count = 0;

        int index = max.indexOf(min);

        while (index !=-1){
            count ++;

            max = max.substring(index + min.length());
            index = max.indexOf(min);

        }

        return count;

    }

}
