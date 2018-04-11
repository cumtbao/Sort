package com.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by shang on 2018/4/10.
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job>{

    //线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    //线程池默认的数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    //线程池最小的数量
    private static final int MIN_WORKER_NUMBERS = 1;
    //工作队列
    private final LinkedList<Job> jobs = new LinkedList<>();
    //工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    //工作者线程数
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    //线程编号生成
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool(){
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num){
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS: num < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : num;
        initializeWorkers(workerNum);
    }

    @Override
    public void execute(Job job) {
        if(job !=null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }

    }

    @Override
    public void shutdown() {
        for (Worker worker:workers) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs){
            if(num + this.workerNum > MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }

    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if(num >= this.workerNum){
                throw new IllegalArgumentException("beyond workNum");
            }

            int count = 0;
            while (count < num){
                Worker worker = workers.get(count);
                if(workers.remove(worker)){
                    worker.shutdown();
                    count ++ ;
                }
            }
            this.workerNum -= count;
        }
    }

    @Override
    public int getJobSize() {

        return jobs.size();

    }
    //初始化线程工作者
    private void initializeWorkers(int num){
        for (int i = 0; i < num; i++) {

            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-worker-" + threadNum.incrementAndGet());
            thread.start();

        }

    }


    //工作者，负责消费任务
    class Worker implements Runnable{

        private volatile boolean running = true;

        @Override
        public void run() {

            while (running){
                Job job = null;
                synchronized (jobs){
                    while (jobs.isEmpty()){

                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            //感知外部对workThread的中断操作
                            Thread.currentThread().interrupt();
                            return;

                        }
                    }
                    job = jobs.removeFirst();
                }
                if(job!=null){
                    try {

                        job.run();
                    }catch (Exception e){

                    }
                }
            }
        }
        public void shutdown(){
            running = false;
        }
    }
}
