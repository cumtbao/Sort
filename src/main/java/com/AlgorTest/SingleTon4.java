package com.AlgorTest;

/**
 * Created by liuzhixiong on 2018/4/14.
 */
public class SingleTon4 {

    private static volatile SingleTon4 singleTon4= null;//volatile禁止了创建对象时，重排序。

    private SingleTon4(){}

    public static SingleTon4 newInstance(){

        if(singleTon4 == null){
            synchronized (SingleTon4.class){
                if(singleTon4 == null){
                    singleTon4 = new SingleTon4();
                }
            }
        }
        return singleTon4;

    }

}
