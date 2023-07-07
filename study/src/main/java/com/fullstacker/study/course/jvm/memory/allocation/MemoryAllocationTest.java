package com.fullstacker.study.course.jvm.memory.allocation;

/**
 * @description:内存分配测试
 * @time: 2021/7/3 13:51
 */
public class MemoryAllocationTest {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {

        testTrenuringThreshold();
    }

    /**
     * 测试MaxTenuringThreshold(设置对象进入老年代的年龄) -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=1
     */
    public static void testTrenuringThreshold() {

        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1M * 4];
        allocation2 = new byte[_1M * 4];
        allocation3 = new byte[_1M * 4];
        allocation3 = null;
        allocation3 = new byte[_1M * 4];
    }
}
