package com.fullstacker.study.course.JAVASE.linkedBlockingQueue;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class UserTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<List<User>> linkedUserList = new LinkedBlockingQueue<List<User>>();
        UserProducer userProducer = new UserProducer(linkedUserList);
        userProducer.start();
        UserConsumer userConsumer = new UserConsumer(linkedUserList);
        userConsumer.start();


    }
}
