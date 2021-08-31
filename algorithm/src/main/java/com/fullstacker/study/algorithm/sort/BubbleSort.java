package com.fullstacker.study.algorithm.sort;

/**
 * @program: course
 * @description: 冒泡排序
 * @author: xgs
 * @create: 2019-10-24 15:36
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {20, 10, 30, 5,3,9};
        System.out.println(array.length);
        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length - i - 1 ; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(array);
    }
}
