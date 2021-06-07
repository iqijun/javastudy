package com.fullstacker.study.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @time: 2020/10/22 11:09
 */
public class ForeachTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("123", "45634", "7892", "abch", "sdfhrthj", "mvkd");
        // foreach  lamda表达式中不能使用continue ，使用return效果与普通循环中continu相同
        list.forEach(e -> {

            if (e.length() >= 5) {
                return;
            }
            System.out.println(e);
        });
    }
}
