package com.fullstacker.study.designpattern.observer;

/**
 * @description:
 * @time: 2021/6/1 20:46
 */
public class Client {
    public static void main(String[] args) {
        Hanfeizi hanfeizi = new Hanfeizi();

        Lisi lisi = new Lisi();
        hanfeizi.addObserver(lisi);

        hanfeizi.sleep();
        hanfeizi.eat();
    }
}
