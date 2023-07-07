package com.fullstacker.study.course.reflect;

/**
 * @program: course
 * @description: 通过反射创建Long对象
 * @author: xgs
 * @create: 2019-04-01 15:59
 */
public class RelfelctLong {
    
    public static void main(String[] args) {
        Class<?> classType = null;
        try {
            classType = Class.forName(String.class.getName());
            Object dto = classType.newInstance();
            System.out.println(dto);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        
    }
    
}
