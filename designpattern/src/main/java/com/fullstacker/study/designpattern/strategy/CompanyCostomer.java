package com.fullstacker.study.designpattern.strategy;

/**
 * @program: course
 * @description: 公司用户的报价
 * @author: xgs
 * @create: 2019-07-28 22:33
 */
public class CompanyCostomer implements Strategy {

    @Override
    public Double quotePrice() {
        System.out.println("我是大客户，这个商品对我7折销售");
        return 700d;
    }
}
