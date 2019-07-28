package com.fullstacker.study.designpattern.strategy;

/**
 * @program: course
 * @description: 针对普通用户的报价
 * @author: xingguishuai
 * @create: 2019-07-28 22:26
 */
public class CustomerNormal implements Strategy {


    @Override
    public Double quotePrice() {
        System.out.println("我是一个普通用户，这个商品对我没有任何优惠");
        return 1000d;
    }
}
