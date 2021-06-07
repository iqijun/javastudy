package com.fullstacker.study.course.concurrent;


import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicRefDemo {


    public static void main(String[] args) {

        AtomicReference atomicReference = new AtomicReference<User>();
        User user1 = new User();
        user1.setName("zhangsan");
        user1.setAge(10);


        User user2 = new User();
        user2.setName("lisi");
        user2.setAge(15);

        //先设置上值
        atomicReference.set(user1);

        System.out.println("交换前："+ atomicReference.get());

        //对比并交换
        atomicReference.compareAndSet(user1, user2);

//        查看新值
        System.out.println("交换后："+atomicReference.get());

    }

}

class User {
    private String name;

    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
