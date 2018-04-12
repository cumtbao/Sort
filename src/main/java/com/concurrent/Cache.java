package com.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by shang on 2018/4/11.
 */
public class Cache {

    static Map<String,Object> map = new HashMap<String,Object>();

    static ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();
    static Lock r = rw1.readLock();
    static Lock w = rw1.writeLock();

    public static final Object get(String key){
        r.lock();
        try {
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    public static final Object put(String key,Object value){

        w.lock();
        try {
            return map.put(key,value);
        }finally {
            w.unlock();
        }

    }

    public static final void clear(){
        w.lock();
        try {

            map.clear();

        }finally {
            w.unlock();
        }


    }




}
