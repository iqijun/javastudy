package com.fullstacker.study.course.algorithm.mergeList;

/**
 * @program: course
 * @description: 合并链表
 * 两个有序链表 n1, n2,将两个链表合并，并返回合并后的链表
 *
 * @author: xingguishuai
 * @create: 2021-06-30 18:23
 */
public class MergeList {

    public static void main(String[] args) {

    }


    public static Node mergeList(Node n1,Node n2){

        Node result =  new Node();

        while (true){

            if(n1 == null &&  n2 == null){
                return  null;
            }
            if(n1 == null){
                return  n2;
            }
            if(n2 == null){
                return  n1;
            }
            if (n1.getValue() <= n2.getValue()){
                result.setValue(n1.getValue());
            }else{
                result.setValue(n2.getValue());

            }
            if( n1.getNext() == null || n2.getNext() == null){
                break;
            }

        }
        return result;

    }
}
