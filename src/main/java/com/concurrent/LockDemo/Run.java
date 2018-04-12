package com.concurrent.LockDemo;

/**
 * Created by shang on 2018/4/12.
 */
public class Run {
    public static void main(String[] args) {

        MyService myService = new MyService();
        MyThread a1 = new MyThread(myService);
        MyThread a2 = new MyThread(myService);
        MyThread a3 = new MyThread(myService);
        MyThread a4 = new MyThread(myService);
        MyThread a5 = new MyThread(myService);
        MyThread a6 = new MyThread(myService);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
        a6.start();

    }
}
