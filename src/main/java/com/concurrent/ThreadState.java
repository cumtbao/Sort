package com.concurrent;

import java.util.concurrent.BlockingDeque;

/**
 * Created by shang on 2018/4/9.
 */
public class ThreadState {


    public static void main(String[] args) {

        new Thread(new TimeWaiting(),"TimeWatingThread").start();
        new Thread(new Waiting(),"Wating").start();
        new Thread(new Blocked(),"blocked-1").start();
        new Thread(new Blocked(),"blocked-2").start();


    }

    static class TimeWaiting implements Runnable{

        @Override
        public void run() {
            SleepUtils.second(100);

        }
    }

    static class Waiting implements Runnable{

        @Override
        public void run() {
            synchronized (Waiting.class){
                try {
                    Waiting.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Blocked implements Runnable{

        @Override
        public void run() {
            synchronized (Blocked.class){
                while (true){
                    SleepUtils.second(100);
                }
            }
        }
    }

}
