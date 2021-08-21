package com.fullstacker.study.jdk8;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mongodb.util.JSON;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: xgs
 * @time: 2020/5/12 23:40
 */
public class StreamTest {

    public static void main(String[] args) {
//        Random random = new Random();
//        random.ints().limit(10).sorted().forEach(System.out::println);


        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().sorted().collect(Collectors.toList());

        List<Byte> collect = numbers.stream().map(Integer::byteValue).collect(Collectors.toList());

        Gson gson = new Gson();
        String s = gson.toJson(squaresList);
        System.out.println(s);
    }
}
