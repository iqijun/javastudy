package com.fullstacker.study.algorithm.mergeList;

/**
 * @program: course
 * @description: 合并链表
 * 两个有序链表 n1, n2,将两个链表合并，并返回合并后的链表
 * @author: xingguishuai
 * @create: 2021-06-30 18:23
 */
public class MergeList {

    public static void main(String[] args) {
        // 第一个链
        Node node1 = new Node();
        node1.setValue(1);
        Node node3 = new Node();
        node3.setValue(3);
        Node node5 = new Node();
        node5.setValue(5);
        node1.setNext(node3);
        node3.setNext(node5);

        // 第2个链
        Node node2 = new Node();
        node2.setValue(2);
        Node node4 = new Node();
        node4.setValue(4);
        Node node6 = new Node();
        node6.setValue(6);
        node2.setNext(node4);
        node4.setNext(node6);

        Node node = mergeList(node1, node2);
        System.out.println(node);

    }


    public static Node mergeList(Node n1, Node n2) {

        Node result = new Node();

        while (true) {

            if (n1 == null && n2 == null) {
                return null;
            }
            if (n1 == null) {
                return n2;
            }
            if (n2 == null) {
                return n1;
            }
            if (n1.getValue() <= n2.getValue()) {
                result.setNext(n2);
                n2 = n2.getNext();
            } else {
                result.setValue(n2.getValue());

            }
            if (n1.getNext() == null || n2.getNext() == null) {
                break;
            }

        }
        return result;

    }
}
