package com.concurrent;

/**
 * Created by shang on 2018/4/10.
 */
public interface ThreadPool<Job extends Runnable> {

    void execute(Job job);

    void shutdown();

    void addWorkers(int num);

    void removeWorker(int num);

    void getJobSize();
}
