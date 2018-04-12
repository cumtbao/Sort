package com.concurrent.LockDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shang on 2018/4/11.
 */
public class BoundedQueue<T> {

    private Object[] items;

    private int addIndex, removeIndex ,count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size){
        items = new Object[size];
    }

    //添加元素
    public void add(T t) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length){
                notFull.await();
            }
            items[addIndex] = t;
            if(++addIndex == items.length){
                addIndex = 0;
            }
            ++count;
            notEmpty.signal();

        }finally {
            lock.unlock();
        }
    }

    public T remove() throws InterruptedException {

        lock.lock();
        try {
            while (count == 0){
                notEmpty.await();
            }
            Object x =items[removeIndex];
            if(++removeIndex == items.length){
                removeIndex = 0;
            }
            --count;
            notFull.await();
            return (T) x;

        }finally {
            lock.unlock();
        }
    }



}
