package com.fullstacker.study.course.JAVASE.linkedBlockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;


public class UserProducer extends Thread {

    LinkedBlockingQueue<List<User>> linkedUserList;


    public UserProducer() {

    }

    public UserProducer(LinkedBlockingQueue<List<User>> linkedUserList) {
        this.linkedUserList = linkedUserList;
    }

    @Override
    public void run() {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 100000; i++) {
            userList.add(new User("test" + i, "xxx" + i, 10 + i));
            int size = userList.size();
            if (size % 5000 == 0) {
                try {
                    List<User> users = new ArrayList<User>(userList);
                    linkedUserList.put(users);
                    userList.clear();
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

            }
        }

    }
}
