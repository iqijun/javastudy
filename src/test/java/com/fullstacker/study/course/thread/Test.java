package com.fullstacker.study.course.thread;

/**
 * @author xingguishuai
 * @create 2017-03-15-9:48
 **/
public class Test {
    static boolean Tprint(char c){
        System.out.println(c);
        return  true;
    }
    public static void main(String[] args){
        int i = 0;
//        for(Tprint('A');Tprint('B')&&( i < 2);Tprint('C')){
//            i++;
//            Tprint('D');
//        }
//        for(System.out.println('a');(i<2);System.out.println('c')){
//            i++;
//            System.out.println('d');
//        }
//        int a = 1;
//        System.out.println(a^2^2);
        for (;i<10;i++){
            System.out.println("外：==========================="+i);
            for(int j=0;j<10;j++){
                System.out.println("内j:"+j);
                if(j==5){
                    break;
                }
            }
        }
    }

}
