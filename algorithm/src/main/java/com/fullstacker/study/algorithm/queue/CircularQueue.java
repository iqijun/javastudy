package com.fullstacker.study.algorithm.queue;

/**
 * @program: course
 * @description: 循环队列
 * @author: xgs
 * @create: 2021-08-31 20:23
 */

public class CircularQueue {
    
    // 数组：items，数组大小：n
    private String[] items;
    
    private int n = 0;
    
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    
    private int tail = 0;
    
    // 申请一个大小为capacity的数组
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }
    
    // 入队
    public boolean enqueue(String item) {
        // 队列满了
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail++;
        if (tail >= n) {
            tail = 0;
        }
        return true;
    }
    
    // 出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head++;
        if (head > n) {
            head = 0;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enqueue("1");
        circularQueue.enqueue("2");
        circularQueue.enqueue("3");
        circularQueue.enqueue("4");
        circularQueue.enqueue("5");
        boolean enqueue = circularQueue.enqueue("6");
        String dequeue = circularQueue.dequeue();
        String dequeue1 = circularQueue.dequeue();
        boolean enqueue1 = circularQueue.enqueue("7");
        boolean enqueue3 = circularQueue.enqueue("8");
        boolean enqueue2 = circularQueue.enqueue("9");
        System.out.println(dequeue);
    }
}
