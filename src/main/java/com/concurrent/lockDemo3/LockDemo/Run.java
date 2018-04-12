package com.concurrent.lockDemo3.LockDemo;

/**
 * Created by shang on 2018/4/12.
 */
public class Run {
    public static void main(String[] args) {

        MyService myService = new MyService();
        MyThreadA myThreadA = new MyThreadA(myService);
        myThreadA.start();

    }
}
