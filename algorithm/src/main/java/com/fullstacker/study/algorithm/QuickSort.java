package com.fullstacker.study.algorithm;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: course
 * @description: 快速排序
 * @author: xingguishuai
 * @create: 2019-03-31 20:43
 */
public class QuickSort {

    public static List<?> sort(List<? extends Number> list) {

        if (CollectionUtils.isEmpty(list)) {
            return list;
        }
        if (list.size() < 2) {
            return list;
        }

        Number baseValue = list.get(0);
        list.remove(baseValue);

        List<Number> lessList = new ArrayList<>();
        List<Number> moreList = new ArrayList<>();
        List<Number> equalList = Lists.newArrayList();
        for (Number number : list) {
            if (number.doubleValue() > baseValue.doubleValue()) {
                moreList.add(number);
            } else if (number.doubleValue() < baseValue.doubleValue()) {
                lessList.add(number);
            } else {
                equalList.add(number);
            }
        }
        List sortLess = sort(lessList);
        List sortMore = sort(moreList);
        List<Number> result = new ArrayList<>();
        result.addAll(sortLess);
        result.add(baseValue);
        result.addAll(equalList);
        result.addAll(sortMore);
        return result;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList();
        list.add(39);
        list.add(3);
        list.add(49);
        List<?> sortList = QuickSort.sort(list);
        Gson gson = new Gson();
        System.out.println(gson.toJson(sortList));
    }
}
