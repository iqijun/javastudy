package com.fullstacker.study.study.designpattern.strategy;

/**
 * @program: course
 * @description: 策略的接口，不同的实例对该策略有不同的实现，比如此时要实现普通用户，vip用户，大客户等不同客户拥有不同的报价 就可以在这个中定义一个报价方法，然后让不同的用户去实现这个方法;
 * <p>
 * 策略模式仅仅对各种策略进行封装，但至于要使用哪一个策略要客户端自己决定
 * @author: xgs
 * @create: 2019-07-27 21:32
 */
public interface Strategy {
    
    Double quotePrice();
    
}
