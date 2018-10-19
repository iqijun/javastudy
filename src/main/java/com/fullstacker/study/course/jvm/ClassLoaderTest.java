package com.fullstacker.study.course.jvm;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader(){
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{ String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is==null){
                        Class<?> aClass = super.loadClass(name);
                        return aClass;
                    }
                    byte[] b = new byte[is.available()]; is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch(IOException e){
                    throw new ClassNotFoundException(name);
                }

            }
        };

        Object obj = myLoader.loadClass("com.fullstacker.study.course.jvm.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        //不同的类加载器加载的类不能用 equals,instaceof 等判断
        System.out.println(obj instanceof ClassLoaderTest);

    }
}