package com.AlgorTest;

/**
 * Created by liuzhixiong on 2018/4/14.
 */
public class SingleTon {

    private SingleTon(){}

    private static SingleTon singleTon = new SingleTon();

    public static SingleTon newInstance(){
        return singleTon;
    }
}
