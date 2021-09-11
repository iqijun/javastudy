package com.fullstacker.study.course.concurrent;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.DelayQueue;

/**
 * 容器类使用
 *
 * @author xgs
 * @create 2017-03-22-11:04
 **/
public class ContainerTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("ad");
        DelayQueue delayQueue = new DelayQueue();

    }
}