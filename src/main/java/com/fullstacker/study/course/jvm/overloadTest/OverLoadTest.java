package com.fullstacker.study.course.jvm.overloadTest;

import java.util.Arrays;
import java.util.List;

/**
 * @program: course
 * @description: 加入泛型的方法重载
 * @author: xingguishuai
 * @create: 2018-10-29 13:51
 */
public class OverLoadTest {

    /**
     * 当有相同的返回类型时，由于泛型擦除后，参数列表时相同的，所以sameReturnType这两个方法不能构成重载
     */

  /*

    public void sameReturnType(List<String> strList){
        System.out.println("strList Method");
    }

    public void sameReturnType(List<Integer> strList){
        System.out.println("strList Method");
    }

    */

   /* public static String diffReturnType(List<String> strList){
        System.out.println("strList Method");
        return  "";
    }

    public static int diffReturnType(List<Integer> strList){
        System.out.println("strList Method");
        return 1;
    }*/
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 23, 4, 5);

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 127;//127为界限
        Integer f = 127;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b)); //TRUE
        System.out.println(g.equals(a + b));//false
    }
}
