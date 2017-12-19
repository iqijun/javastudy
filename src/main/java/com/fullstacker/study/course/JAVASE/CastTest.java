package com.fullstacker.study.course.JAVASE;

/**
 * 强制类型转换测试
 *
 * @author xingguishuai
 * @create 2017-12-19-17:53
 **/
public class CastTest {

    public static void main(String[] args) {

        //1. float 转doubble
        //基本数据类型可以直接赋值
        float f1 = 1.003f;
        double d1 = f1;
        System.out.println(d1);
        //包装类强转报错
        Float f2 = 1.003f;
//        Double d2 = (Double) f2; // 编译错误
        double d2 = f2;  //包装类转为基本类型没问题
        System.out.println(d2);

        //基本类型转换为包装类型
        float f3 = 1.003f;
//        Double d3 = (Double) f3; //编译错误
        Double d3 = null;
        System.out.println(d3);


        System.out.println("=================================");


        //2. double 转float
        //基本类型强转
        double d4 = 0.123d;
        float f4 = (float) d4;
        System.out.println(f4);

        Double d5 = 0.234d;
//        float f5 = (float)d5; //编译错误



        //正确转换方式
        Float f = 1.0f;
        Double d = Double.valueOf(String.valueOf(f));
        System.out.println(d);
    }
}
