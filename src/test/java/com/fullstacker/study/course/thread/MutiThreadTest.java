package com.fullstacker.study.course.thread;


/** 
* MutiThread Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 3, 2017</pre> 
* @version 1.0 
*/ 
public class MutiThreadTest { 

    public static void main(String[] args) throws Exception {
        int i = 0;
        while (i<10){
            try {
                System.out.println("i:"+i);
                i++;
                if(i==5){
                    throw new Exception("我就是个无聊的异常");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception("抛抛抛");
            }
        }
    }

} 
