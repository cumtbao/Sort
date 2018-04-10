package com.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by shang on 2018/4/9.
 */
public class Shutdown {
    public static void main(String[] args) throws InterruptedException {

        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();

        TimeUnit.SECONDS.sleep(1);

        countThread.interrupt();

        Runner two = new Runner();

        countThread = new Thread(two,"CountThread");

        countThread.start();

        TimeUnit.SECONDS.sleep(1);

        two.cancel();

    }

    private static class Runner implements Runnable{

        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {

            while (on && !Thread.interrupted()){
                i++;
            }
            System.out.println("Count i =" +i);

        }
        public void cancel(){
            on = false;
        }
    }

}
