package com.fullstacker.study.jdk8;


import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: xgs
 * @time: 2020/5/12 23:40
 */
public class StreamTest {
    
    public static void main(String[] args) {
        //        simpleTest();
        //        streamApi();
        //        summarizTest();
        joiningTest();
        
    }
    
    public static void reducingTest() {
        Integer collect = Stream.iterate(0, t -> t + 1).limit(10)
                .collect(Collectors.reducing(0, Integer::valueOf, (i, j) -> i + j));
        
        
    }
    
    public static void joiningTest() {
        String collect = Stream.iterate(0, t -> t + 1).limit(10).map(i -> String.valueOf(i))
                .collect(Collectors.joining(","));
        System.out.println(collect);
    }
    
    public static void summarizTest() {
        IntSummaryStatistics collect = Stream.iterate(0, t -> t + 1).limit(10)
                .collect(Collectors.summarizingInt(Integer::valueOf));
        System.out.println(JSONUtil.toJsonStr(collect));
    }
    
    private static void streamApi() {
        // 输出偶数
        //        Stream.iterate(0,n-> n+2).limit(100).forEach(System.out::println);
        // 输出斐波那契数列
        Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]}).limit(10).map(t -> t[0])
                .forEach(System.out::println);
    }
    
    private static void simpleTest() {
        //        Random random = new Random();
        //        random.ints().limit(10).sorted().forEach(System.out::println);
        
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().sorted().collect(Collectors.toList());
        
        List<Byte> collect = numbers.stream().map(Integer::byteValue).collect(Collectors.toList());
    }
    
    
}
