package com.AlgorTest;

/**
 * Created by liuzhixiong on 2018/4/14.
 */
public class SingleTon2 {

    private SingleTon2(){}

    private static SingleTon2 singleTon2 = null;

    public static synchronized SingleTon2 newInstance(){
        if(singleTon2==null){
            return new SingleTon2();
        }

        return singleTon2;
    }
}
