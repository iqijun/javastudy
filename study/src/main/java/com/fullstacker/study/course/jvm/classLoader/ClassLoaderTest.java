package com.fullstacker.study.course.jvm.classLoader;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            // 此处重写了loadclass方法破坏了双亲委派，所以下面加载出来的类 instanceof 返回为false
            // 如果重写findClass方法 由于双亲委派规则，在classpath路径下的类依然会
            // 被applicationClassLoader加载 instancOf 返回的会是是true ，如下方myLoader2
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        Class<?> aClass = super.loadClass(name);
                        return aClass;
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }

            }
        };

        Object obj = myLoader.loadClass("com.fullstacker.study.course.jvm.classLoader.ClassLoaderTest").newInstance();
        System.out.println("myLoader className: " + obj.getClass());
        //不同的类加载器加载的类不能用 equals,instaceof 等判断
        System.out.println("myLoader instanceof : " + (obj instanceof ClassLoaderTest));

        ClassLoader myLoader2 = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        Class<?> aClass = super.loadClass(name);
                        return aClass;
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }

            }
        };

        Object obj2 = myLoader2.loadClass("com.fullstacker.study.course.jvm.classLoader.ClassLoaderTest").newInstance();
        System.out.println("myLoader2 className: " + obj2.getClass());
        System.out.println("myLoader2 instanceof :" + (obj2 instanceof ClassLoaderTest));
    }


}