package com.concurrent;

/**
 * Created by shang on 2018/4/9.
 */
public class Synchronized {

    public static void main(String[] args) {

        synchronized (Synchronized.class){

        }
        m();
    }

    public static synchronized void m(){

    }

}

