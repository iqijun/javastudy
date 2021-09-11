package com.fullstacker.study.course.JAVASE;

/**
 * @program: course
 * @description: �ݹ����main��������
 * @author: xgs
 * @create: 2021-09-11 09:40
 */
public class MainRecurrence {

    static int count = 0;
    public static void main(String[] args) {
        if(count < 3){
            count++;
            System.out.println("count==="+ count);
            // �ݹ����main����
            main(null);
        }else{
            return;
        }
        System.out.println("hello world");
    }
}
