package com.fullstacker.study.study.designpattern.strategy;

/**
 * @program: course
 * @description: 针对vip用户的报价
 * @author: xgs
 * @create: 2019-07-28 22:29
 */
public class VipCustomer implements Strategy {
    
    @Override
    public Double quotePrice() {
        System.out.println("我是vip用户，这个商品对我8折销售");
        return 800d;
    }
}
