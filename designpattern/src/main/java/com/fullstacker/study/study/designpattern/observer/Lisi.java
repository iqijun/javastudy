package com.fullstacker.study.study.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @description:
 * @time: 2021/6/1 16:52
 */
public class Lisi implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("密探来报。。。");
        doSomething();
    }

    private void doSomething() {

        System.out.println("汇报给大王");
    }
}
