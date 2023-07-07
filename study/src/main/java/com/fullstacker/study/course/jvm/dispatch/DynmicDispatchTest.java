package com.fullstacker.study.course.jvm.dispatch;

/**
 * @program: course
 * @description: 动态分派测试
 * @author: xgs
 * @create: 2021-07-15 09:49
 */
public class DynmicDispatchTest {

    static class Father {

        int money = 1;

        static int static_field = 10;

        public Father() {
            money = 2;
            System.out.println(" father money:" + money);
        }
    }

    static class Son extends Father {

        int money = 3;

        public Son() {
            money = 4;
            System.out.println(" son money:" + money);
        }
    }

    public static void main(String[] args) {
        Father guy = new Son();
        System.out.println("guy money:" + guy.money);
        System.out.println(Son.static_field);

        Son[] sonArray = new Son[10];
    }
}
