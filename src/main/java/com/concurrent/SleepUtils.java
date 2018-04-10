package com.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by shang on 2018/4/9.
 */
public class SleepUtils {

    public static final  void second(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
