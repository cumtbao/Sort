package com.concurrent;

/**
 * Created by shang on 2018/4/9.
 *守护线程，必须在启动线程之前设置
 */
public class Deamon {

    public static void main(String[] args) {
        Thread deamonRunnable = new Thread(new DeamonRunnable(), "DeamonRunnable");
        deamonRunnable.setDaemon(true);
        deamonRunnable.start();
    }

    static class DeamonRunnable implements Runnable{

        @Override
        public void run() {
            try {

                SleepUtils.second(10);
            }finally {
                System.out.println("DeamonThread finally run.");
            }
        }
    }
}
