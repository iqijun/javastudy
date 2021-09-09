package com.fullstacker.study.algorithm.sort;

/**
 * @program: course
 * @description: 插入排序
 * 插入排序整体思路： 将数组前半部分假设为有序集，然后将数组后面部分的数据不断和前半部分的数据对比，如果后边的数小，就将前半部分的数依次后移。
 * 对比时，从有序部分的尾部开始，逐渐向头部移动，这样相对于从头部——>尾部的顺序，数据移动次数更少
 * @author: xgs
 * @create: 2021-09-09 22:49
 */
public class InserctionSort {

    public static void main(String[] args) {
        int array[]  = new int[]{3,8,6,2,7,4,3,5};
        sort(array);
        System.out.println(array);
    }

    public static void sort(int[]  array){

        if(array.length <= 1){
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i-1;
            for ( ; j >= 0; j--) {
                if (array[j] > value){
                    // 拿array[i]和前面的每一个数依次对比，如果前面的数小，则向后移动
                    array[j+1] = array[j];

                }else{
                    // 由于前面的数是有序排列的，所以当找到比array[i]小的数时，这个数之前的数一定比array[i]小，可以直接break;
                    break;
                }
            }
            array[j+1] = value;


        }

    }
}
