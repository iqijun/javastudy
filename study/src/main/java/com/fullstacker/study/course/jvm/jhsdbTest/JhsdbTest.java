package com.fullstacker.study.course.jvm.jhsdbTest;

/**
 * @description:
 * @time: 2021/7/3 17:45
 */
public class JhsdbTest {

    private static Integer staticInt = new Integer(100);

    private Integer instanceInt = new Integer(200);

    public static void main(String[] args) {

        foo();
    }

    private static void foo() {
        Integer localInt = new Integer(300);
        System.out.println("哈哈哈哈");
    }
}
