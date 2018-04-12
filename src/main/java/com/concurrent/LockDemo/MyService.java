package com.concurrent.LockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shang on 2018/4/12.
 */
public class MyService {
    private Lock lock = new ReentrantLock();

    public void testMethod(){
        lock.lock();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadName="+ Thread.currentThread().getName()+(" "+(i+1)));
            }
        }finally {
            lock.unlock();
        }

    }
}
