package com.fullstacker.study.course.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: course
 * @description: 反射的三种方式
 * @author: xingguishuai
 * @create: 2021-05-30 22:11
 */
public class ReflectByThreeWay {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // 第一种方式
        Class<?> aClass = Class.forName("com.fullstacker.study.course.reflect.ReflectPo");
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();

        // 第二种方式
        ReflectPo reflectPo = new ReflectPo();
        Class<? extends ReflectPo> aClass1 = reflectPo.getClass();

        // 第三种方式
        Class<? extends Class> aClass2 = ReflectPo.class.getClass();

    }
}
