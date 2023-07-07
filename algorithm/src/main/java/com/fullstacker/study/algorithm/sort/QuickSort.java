package com.fullstacker.study.algorithm.sort;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: course
 * @description: 快速排序
 * @author: xgs
 * @create: 2019-03-31 20:43
 */
public class QuickSort {
    
    /**
     * 这种方式新建了两个list用于存储“已处理的数据”，用到了额外空间，所以不是原地算法 可以进行优化
     *
     * @param list
     * @return
     */
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
    
    
    /**
     * @param array      需排序的数组
     * @param startIndex 从第几个元素开始排序，递归时使用
     * @param endIndex   排序结束的下标，递归使用
     */
    public static void quckSort2(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int partitionIndex = partition(array, startIndex, endIndex);
        quckSort2(array, startIndex, partitionIndex - 1);
        quckSort2(array, partitionIndex + 1, endIndex);
        
    }
    
    // 获取分位点
    private static int partition(int[] array, int startIndex, int endIndex) {
        // 选定一个分隔的数字，选择最后一个元素
        int pivot = array[endIndex];
        int i = startIndex;
        int tmp;
        for (int j = i; j < endIndex; j++) {
            if (array[j] < pivot) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        array[endIndex] = array[i];
        array[i] = pivot;
        return i;
    }
    
    public static void main(String[] args) {
        //        ArrayList<Integer> list = Lists.newArrayList();
        //        list.add(39);
        //        list.add(3);
        //        list.add(49);
        //        List<?> sortList = QuickSort.sort(list);
        //        Gson gson = new Gson();
        //        System.out.println(gson.toJson(sortList));
        
        int array[] = new int[] {3, 8, 6, 2, 7, 4, 3, 5};
        quckSort2(array, 0, array.length - 1);
        System.out.println(array);
    }
}
