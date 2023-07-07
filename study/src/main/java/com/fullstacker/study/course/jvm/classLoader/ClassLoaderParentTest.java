package com.fullstacker.study.course.jvm.classLoader;

//import sun.misc.Launcher;

/**
 * @program: course
 * @description:
 * @author: xgs
 * @create: 2021-07-14 16:59
 */
public class ClassLoaderParentTest {

    // 在类加载阶段被初始化为0
    static int a;

    // 在创建实例是被初始化为0
    int b;

    public static void main(String[] args) {

        //        ClassLoader classLoader = new ClassLoader();
        //        Launcher.getLauncher().getClassLoader();
        ClassLoaderParentTest classLoaderTest = new ClassLoaderParentTest();
        classLoaderTest.getClass().getClassLoader().getParent();
        System.out.println(classLoaderTest.a);
        System.out.println(classLoaderTest.b);
    }
}
