package com.fullstacker.study.course.JAVASE.switchTest;

/**
 * @author xingguishuai@xiaomi.com
 * @since 2023-07-19 15:56
 **/
public class switchTest {
    
    public static void main(String[] args) {
        String a = "b";
        boolean b = swtichTest(a);
        System.out.println(b);
    }
    
    public static boolean swtichTest(String a){
        
        switch (a){
            case "a":
                System.out.println("a");
                return true;
            case "b":
                System.out.println("b");
                break;
            default:
                System.out.println("default");
        }
        return false;
    }
}
