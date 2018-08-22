package com.fullstacker.study.course.JAVASE;

/**
 * 方法传值测试
 */

public class TransValueTest {

    public void transValue(int baseType,Integer objType){
        Integer integer = new Integer(10);
        baseType = integer;
        objType = integer;
    }

    public static  void main(String[] args){
        TransValueTest transValueTest = new TransValueTest();
        int baseType = 1 ;
        Integer objType = 12;
        transValueTest.transValue(baseType,objType);
        System.out.println("baseT:"+baseType);
        System.out.println("objType:"+objType);
    }
}
