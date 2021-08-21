package com.fullstacker.study.designpattern.singleton;

/**
 * 饿汉模式 饿汉模式是线程安全的单例模式
 *
 * @author xgs
 * @create 2017-03-27-15:53
 **/
public class HungrySingleton {

    private static HungrySingleton intance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getIntance() {
        return intance;
    }
}
