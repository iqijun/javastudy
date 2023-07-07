package com.fullstacker.study.course.other;

import java.text.DecimalFormat;

/**
 * @author xgs
 * @create 2017-07-25-16:57
 **/
public class ListComparator {
    
    public static void main(String[] args) {
        //        ArrayList<Integer> list = new ArrayList<>(null);
        //        for (int i =0;i<100;i++){
        //            list.add(i);
        //        }
        //        Collections.sort(list, new Comparator<Integer>() {
        //            @Override
        //            public int compare(Integer o1, Integer o2) {
        //                return o2-o1;
        //            }
        //        });
        //        System.out.println("============");
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        Double rightRatio = 123.23365899d;
        String format = decimalFormat.format(rightRatio) + "%";
        System.out.println(format);
    }
}
