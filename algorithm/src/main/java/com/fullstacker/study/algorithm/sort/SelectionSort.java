package com.fullstacker.study.algorithm.sort;

/**
 * @program: course
 * @description: 选择排序
 * 选择排序：在数组中找出最小的数，插入到数组第一个位置，然后寻找第二小的数插入到第二个位置，以此类推
 * @author: xgs
 * @create: 2021-09-09 23:15
 */
public class SelectionSort {

    public static void main(String[] args) {
        int array[]  = new int[]{3,8,6,2,7,4,3,5,1};
        sort(array);
        System.out.println(array);
    }

    private static void sort(int[] array){

        int min,minIndex; // 记录最小的数，和这个数所在的下标
        for (int i = 0; i < array.length; i++) {
            min = array[i];
            minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < min){
                    min = array[j];
                    minIndex = j;
                }
            }
            // array[i] 与最小的数交换位置
            array[minIndex] = array[i];
            array[i] = min;

        }


    }
}
