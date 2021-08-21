package com.fullstacker.study.course.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: course
 * @description: 线程安全集合类的演示
 * 怎么保证集合类的线程安全
 * 1. 使用synchronized关键字
 * 2. 使用Collections提供的工具方法保证线程安全，底层还是使用Synchronized关键字
 * Collections.synchronizedCollection(list)
 * Collections.synchronizedList()
 * Collections.synchronizedSet();
 * Collections.synchronizedMap();
 * 3. 使用juc包中的提供的集合类：
 * CopyOnWriteArrayList
 * CopyOnWriteArraySet
 * ConcurrentHashMap
 * @author: xgs
 * @create: 2019-05-25 16:32
 */
public class ThreadSafeCollectionsDemo {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        Collection<Object> objects = Collections.synchronizedCollection(list);


        CopyOnWriteArrayList<Object> cowList = new CopyOnWriteArrayList<>();
        //copyOnWrit类在新增元素的时候，会将add方法加锁，防止其他线程调用add方法时产生线程不安全问题。
        //在加锁后，回将底层保存元素的数组copy一份，并利用这个拷贝的副本创建一个新的数组，然后将要追加的元素放到新数组中
        // 最后保存元素的数组指向包含要追加元素的新数组
        // 然后解锁
        cowList.add(new Object());


    }

}
