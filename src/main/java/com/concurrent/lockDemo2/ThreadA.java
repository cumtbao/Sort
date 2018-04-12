package com.concurrent.lockDemo2;


/**
 * Created by shang on 2018/4/12.
 */
public class ThreadA extends Thread{

    private MyService myService;
    public ThreadA(MyService myService){
        super();
        this.myService = myService;
    }
    @Override
    public void run() {
        myService.methodA();
    }
}
