package com.fullstacker.study.designpattern.strategy;

/**
 * @program: course
 * @description:
 * @author: xingguishuai
 * @create: 2019-07-27 21:31
 */
public class PriceStrategy {

    private Strategy strategy;

    public PriceStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double quotePriceByCustomerType() {
        return strategy.quotePrice();
    }
}
