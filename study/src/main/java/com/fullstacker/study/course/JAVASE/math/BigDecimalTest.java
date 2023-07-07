package com.fullstacker.study.course.JAVASE.math;

import java.math.BigDecimal;

/**
 * @author xgs
 * @create 2018-09-11-13:27
 **/
public class BigDecimalTest {
    
    public static void main(String[] args) {
        
        Integer rightQuestionNum = 22;
        Integer allQuestionNum = 45;
        Float rightRate = 0f;
        BigDecimal bigDecimal = new BigDecimal(rightQuestionNum.toString());
        BigDecimal divisor = new BigDecimal(allQuestionNum.toString());
        BigDecimal rightRateDecimal = bigDecimal.divide(divisor, 2, BigDecimal.ROUND_HALF_UP);
        rightRate = rightRateDecimal.floatValue();
        System.out.println(rightRate);
        
        BigDecimal bigDecimal1 = new BigDecimal(rightQuestionNum / allQuestionNum.floatValue())
                .setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal1);
        
        
    }
}
