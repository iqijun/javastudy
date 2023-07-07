package com.fullstacker.study.study.designpattern.strategy;

/**
 * @program: course
 * @description: 针对普通用户的报价
 * @author: xgs
 * @create: 2019-07-28 22:26
 */
public class NormalCustomer implements Strategy {
    
    
    @Override
    public Double quotePrice() {
        System.out.println("我是一个普通用户，这个商品对我没有任何优惠");
        return 1000d;
    }
}
