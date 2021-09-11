package com.fullstacker.study.interview.extendsTest;

/**
 * @program: course
 * @description:
 * @author: xgs
 * @create: 2021-04-04 16:51
 */
public class Parent {

    private  String  firstName;

    private String lastName;

    private int  age;

    public Parent(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        System.out.println(" constructor of parent");
    }
}
