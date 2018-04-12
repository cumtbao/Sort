package com.concurrent.lockDemo2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shang on 2018/4/12.
 */
public class MyService {

    private Lock lock = new ReentrantLock();

    public void methodA(){
        lock.lock();
        try {
            System.out.println("methodA begin ThreadName= "+Thread.currentThread().getName() +
            "time="+System.currentTimeMillis());
            TimeUnit.MICROSECONDS.sleep(3000);
            System.out.println("methodA end ThreadName= "+Thread.currentThread().getName() +
                    "time="+System.currentTimeMillis());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
    public void methodB(){
        lock.lock();
        try {
            System.out.println("methodA begin ThreadName= "+Thread.currentThread().getName() +
                    "time="+System.currentTimeMillis());
            TimeUnit.MICROSECONDS.sleep(3000);
            System.out.println("methodA end ThreadName= "+Thread.currentThread().getName() +
                    "time="+System.currentTimeMillis());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
