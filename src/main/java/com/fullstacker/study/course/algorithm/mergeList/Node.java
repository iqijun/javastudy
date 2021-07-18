package com.fullstacker.study.course.algorithm.mergeList;

/**
 * @program: course
 * @description: 链表节点
 * @author: xingguishuai
 * @create: 2021-06-30 18:13
 */
public class Node {
    private  int value;

    private Node next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
