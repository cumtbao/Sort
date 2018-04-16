package com.AlgorTest;

/**
 * Created by liuzhixiong on 2018/4/14.
 */
public class SingleTon3 {

    private SingleTon3(){}

    static  class InnerClass{
        private static SingleTon3 singleTon3 = new SingleTon3();
    }

    public static SingleTon3 newInstance(){

        return InnerClass.singleTon3;
    }

}
