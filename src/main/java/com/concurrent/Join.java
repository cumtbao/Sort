package com.concurrent;

import java.awt.image.TileObserver;
import java.util.concurrent.*;

/**
 * Created by shang on 2018/4/9.
 */
public class Join {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        ExecutorService executorService = Executors.newFixedThreadPool(3);


        Future<?> one = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Future<?> two = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Future<?> three = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Object o = one.get();

        Object o1 = two.get();

        Object o2 = three.get();

        System.out.println("end");
       /* Thread previous = Thread.currentThread();
        for (int i = 0; i <10 ; i++) {
            Thread thread = new Thread(new Domino(previous), i + "");
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+"123");*/
    }

    static class Domino implements Runnable{

        private Thread thread;

        public Domino(Thread thread){
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"terminate.");
        }
    }
}
