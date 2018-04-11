package com.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuzhixiong on 2018/4/11.
 */
//分布耗时统计
public class Statistics {

    private static final Logger log = LoggerFactory.getLogger("Statistics");

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    private List<Long> linkedList = null;

    private Statistics(){

        linkedList = new LinkedList<>();
        linkedList.add(System.currentTimeMillis());

    }

    private Statistics(String name){
        this.name = name;
        linkedList = new LinkedList<>();
        linkedList.add(System.currentTimeMillis());
    }
    //初始化
    public static Statistics newInstance() {

        return new Statistics();
    }

    public static Statistics newInstance(String name) {

        return new Statistics(name);
    }
    //标记
    public void mark(){
        linkedList.add(System.currentTimeMillis());
    }
    //结束
    public void end(){
        linkedList.add(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append("[["+name+"]]");

        int size = linkedList.size();
        int step = 0;
        for (int i = 1; i < size; i++) {
            sb.append(++step).append(":").append(linkedList.get(i)-linkedList.get(i-1)).append(" ");
        }
        log.info(sb.toString());
    }

    //大于debug时长的才记录
    public void end(long debug){

        long start = linkedList.get(0);
        long end = System.currentTimeMillis();
        if(end - start >= debug){
            end();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Statistics stat = Statistics.newInstance("test");

        TimeUnit.MILLISECONDS.sleep(20);
        stat.mark();
        TimeUnit.MILLISECONDS.sleep(30);

        stat.mark();
        TimeUnit.MILLISECONDS.sleep(40);
        stat.end(10);


    }


}
