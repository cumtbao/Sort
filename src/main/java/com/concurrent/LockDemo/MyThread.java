package com.concurrent.LockDemo;

/**
 * Created by shang on 2018/4/12.
 */
public class MyThread extends Thread{





    private MyService myService;
    public MyThread(MyService myService){
        super();
        this.myService = myService;
    }
    @Override
    public void run() {
        myService.testMethod();
    }
}
