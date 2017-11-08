package com.fullstacker.study.course.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射示例
 *
 * @author xingguishuai
 * @create 2017-11-08-16:13
 **/
public class ReflectDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field[] declaredFields = ReflectPo.class.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            System.out.println(declaredField.getName());
//        }
//        Field id = ReflectPo.class.getDeclaredField("id");
        ReflectPo reflectPo = new ReflectPo();
//        id.setAccessible(true);
//        id.set((Object) reflectPo,1000L);
//        System.out.println(id.get(reflectPo));

        Field testStatic = ReflectPo.class.getDeclaredField("testStatic");
        //private修饰的变量需设置可见
        testStatic.setAccessible(true);
        //静态属性set方法的第一个参数可以为null，非静态属性不可以
        testStatic.set(null,129303+"1111");
        System.out.println(testStatic.get(null));

        Method setName = ReflectPo.class.getMethod("setName", String.class);
        Object xgs = setName.invoke(reflectPo, "xgs");
        Method getName = ReflectPo.class.getMethod("getName");
        Object invoke = getName.invoke(reflectPo);
        System.out.println(invoke);
    }
}
