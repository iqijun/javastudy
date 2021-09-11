package com.fullstacker.study.designpattern.observer;


import java.util.Observable;

/**
 * @description:  韩非子是一个被观察的对象，他的一举一动都要被通知到观察者
 * @time: 2021/6/1 16:54
 */
public class Hanfeizi extends Observable {

    public void eat(){
        System.out.println("韩非子吃东西了");
        // 被观察者状态改变了
        super.setChanged();
        // 通知监听者  是不是傻  为什么要主动通知。。
        super.notifyObservers();
    }

    public void  sleep(){
        System.out.println("韩非子睡觉了");
        super.setChanged();
        super.notifyObservers();
    }

    public void heiheihei(){
        System.out.println("韩非子 嘿嘿嘿。。。");
        super.setChanged();
        super.notifyObservers();
    }


}
