package com.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by shang on 2018/4/9.
 */
public class Interrupted {


    public static void main(String[] args) throws InterruptedException {
        Thread sleepThread = new Thread(new SleepRunner(), "sleepThread");
        Thread busyThread = new Thread(new BusyRunner(), "busyThread");
        sleepThread.setDaemon(true);
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is "+ sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is "+ busyThread.isInterrupted());

        SleepUtils.second(2);


    }


    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true){

            }
        }
    }
}

