package com.fullstacker.study.course.concurrent;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 容器类使用
 *
 * @author xingguishuai
 * @create 2017-03-22-11:04
 **/
public class ContainerTest {

    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<String>();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("ad");
    }
}