package com.fullstacker.study.jdk8;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @description:
 * @time: 2021/2/23 17:59
 */
public class LambdTest {
    
    public static void main(String[] args) {
        //        Runnable r = LambdTest::run;
        //        r.run();
        //        System.out.println("========1111");
        
        Function<String, String> toUpperCase = String::toUpperCase; // 使用方法引用获取到function对象
        Function<String, String> lowerCase = String::toLowerCase;
        toUpperCase.andThen(lowerCase);
        String test = "teest";
        String apply = toUpperCase.apply(test);
        System.out.println(apply);
        
        Function<String, String> compose = lowerCase.compose(toUpperCase);
        String apply1 = compose.apply(test);
        
        System.out.println(apply1);
    }
    
    private static void predicateTest() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        
        System.out.println("Print all numbers:");
        evaluate(list, (n) -> true);
        
        System.out.println("Print no numbers:");
        evaluate(list, (n) -> false);
        
        System.out.println("Print even numbers:");
        evaluate(list, (n) -> n % 2 == 0);
        
        System.out.println("Print odd numbers:");
        evaluate(list, (n) -> n % 2 == 1);
        
        System.out.println("Print numbers greater than 5:");
        evaluate(list, (n) -> n > 5);
        
    }
    
    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n + " ");
            }
            
        }
    }
    
    private static void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("---------hello world");
    }
}
