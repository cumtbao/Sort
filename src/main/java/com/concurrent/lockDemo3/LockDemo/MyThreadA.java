package com.concurrent.lockDemo3.LockDemo;

/**
 * Created by shang on 2018/4/12.
 */
public class MyThreadA extends Thread{


    private MyService myService;
    public MyThreadA(MyService myService){
        super();
        this.myService = myService;
    }
    @Override
    public void run() {
        myService.waitMethod();
    }
}
