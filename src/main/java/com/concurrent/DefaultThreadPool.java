package com.concurrent;

import java.util.LinkedList;

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




    @Override
    public void execute(Job job) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void addWorkers(int num) {

    }

    @Override
    public void removeWorker(int num) {

    }

    @Override
    public void getJobSize() {

    }
    //初始化线程工作者
    private void initializeWorkers(int num){
        for (int i = 0; i < num; i++) {

            Worker worker = new Worker();

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
