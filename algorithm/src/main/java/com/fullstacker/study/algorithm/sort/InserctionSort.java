package com.fullstacker.study.algorithm.sort;

/**
 * @program: course
 * @description: ��������
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
                    // ��array[i]��ǰ���ÿһ�������ζԱȣ����ǰ�����С��������ƶ�
                    array[j+1] = array[j];

                }else{
                    // ����ǰ��������������еģ����Ե��ҵ���array[i]С����ʱ�������֮ǰ����һ����array[i]С������ֱ��break;
                    break;
                }
            }
            array[j+1] = value;


        }

    }
}
