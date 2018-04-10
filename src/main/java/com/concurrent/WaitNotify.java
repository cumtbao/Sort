package com.concurrent;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by shang on 2018/4/9.
 */
public class WaitNotify {

    static boolean flag = true;
    static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {

        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();

        TimeUnit.SECONDS.sleep(1);

        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();

    }

    static class Wait implements Runnable{

        @Override
        public void run() {

            synchronized (lock){

                while (flag){
                    System.out.println("lock is true ,wait...");
                    try {
                        lock.wait();
                        System.out.println("lock is true 123 ,wait...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("lock is false, running...");

            }
        }
    }

    static class Notify implements Runnable{

        @Override
        public void run() {

            synchronized (lock){
                System.out.println("hold lock notify");
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }

            synchronized (lock){
                System.out.println("hold the lock again");
                SleepUtils.second(5);
            }

        }
    }

}
