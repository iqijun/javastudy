package com.fullstacker.study.course.JAVASE.linkedBlockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class UserConsumer extends Thread {
    
    LinkedBlockingQueue<List<User>> linkedUserList;
    
    List<User> listUser = new ArrayList<User>();
    
    private boolean isRunning = true;//是否退出线程的标志
    
    public UserConsumer() {
    
    }
    
    public UserConsumer(LinkedBlockingQueue<List<User>> linkedUserList) {
        this.linkedUserList = linkedUserList;
    }
    
    @Override
    public void run() {
        int count = 0;
        while (isRunning) {
            try {
                count++;
                listUser = linkedUserList.poll(10, TimeUnit.SECONDS);
                if (listUser != null) {
                    System.err.println("consumer" + count + ":" + listUser.size());
                } else {
                    isRunning = false;
                }
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            
        }
    }
}
