package com.fullstacker.study.course.JAVASE;

/**
 * @program: course
 * @description: 递归调用main方法测试
 * @author: xgs
 * @create: 2021-09-11 09:40
 */
public class MainRecurrence {

    static int count = 0;
    public static void main(String[] args) {
        if(count < 3){
            count++;
            System.out.println("count==="+ count);
            // 递归调用main函数
            main(null);
        }else{
            return;
        }
        System.out.println("hello world");
    }
}
