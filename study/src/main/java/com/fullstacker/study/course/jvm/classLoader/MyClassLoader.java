package com.fullstacker.study.course.jvm.classLoader;

/**
 * @program: course
 * @description: 自定义的classLoader
 * @author: xgs
 * @create: 2021-07-16 23:32
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }
}
