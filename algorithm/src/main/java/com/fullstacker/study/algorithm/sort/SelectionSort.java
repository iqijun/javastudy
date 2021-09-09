package com.fullstacker.study.algorithm.sort;

/**
 * @program: course
 * @description: ѡ������
 * ѡ���������������ҳ���С���������뵽�����һ��λ�ã�Ȼ��Ѱ�ҵڶ�С�������뵽�ڶ���λ�ã��Դ�����
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

        int min,minIndex; // ��¼��С����������������ڵ��±�
        for (int i = 0; i < array.length; i++) {
            min = array[i];
            minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < min){
                    min = array[j];
                    minIndex = j;
                }
            }
            // array[i] ����С��������λ��
            array[minIndex] = array[i];
            array[i] = min;

        }


    }
}
