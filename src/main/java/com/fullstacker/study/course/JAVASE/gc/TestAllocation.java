package com.fullstacker.study.course.JAVASE.gc;

public class TestAllocation {

    private static  final int _1M = 1024*1024;

    /**
     *vm 参数 -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX+printGCDetails -XX:SurvivorRatio=8
     *
     *UseParNewGC
     *
     */
    public static  void testAllocation(){
        byte[] allcation1,allcation2,allcation3,allcation4;
        allcation1 = new byte[2*_1M];
        allcation2 = new byte[2*_1M];
        allcation3 = new byte[2*_1M];
        allcation4 = new byte[4*_1M];

    }

    public static  void  main(String[] args){
        testAllocation();
    }
}
