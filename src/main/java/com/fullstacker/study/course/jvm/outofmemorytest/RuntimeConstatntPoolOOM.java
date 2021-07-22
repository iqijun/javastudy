package com.fullstacker.study.course.jvm.outofmemorytest;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 运行时常量池OOM测试
 * @time: 2021/6/20 16:50
 */
public class RuntimeConstatntPoolOOM {
    // GC overhead limit exceeded
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
            System.out.println(i);
        }
    }
}
