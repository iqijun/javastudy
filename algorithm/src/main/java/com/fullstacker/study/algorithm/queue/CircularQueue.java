package com.fullstacker.study.algorithm.queue;

/**
 * @program: course
 * @description: ѭ������
 * @author: xgs
 * @create: 2021-08-31 20:23
 */

public class CircularQueue {
    // ���飺items�������С��n
    private String[] items;
    private int n = 0;
    // head��ʾ��ͷ�±꣬tail��ʾ��β�±�
    private int head = 0;
    private int tail = 0;

    // ����һ����СΪcapacity������
    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // ���
    public boolean enqueue(String item) {
        // ��������
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail++;
       if(tail >= n){
           tail = 0;
       }
        return true;
    }

    // ����
    public String dequeue() {
        // ���head == tail ��ʾ����Ϊ��
        if (head == tail) return null;
        String ret = items[head];
        head++;
        if (head > n){
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
