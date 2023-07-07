package com.fullstacker.study.study.designpattern.strategy;

/**
 * @program: course
 * @description: 策略模式调用示例
 * @author: xgs
 * @create: 2019-07-28 22:46
 */
public class StrategyDemo {
    
    public static void main(String[] args) {
        PriceStrategy normalStrategy = new PriceStrategy(new NormalCustomer());
        normalStrategy.quotePriceByCustomerType();
        
        PriceStrategy vipStrategy = new PriceStrategy(new VipCustomer());
        
        vipStrategy.quotePriceByCustomerType();
        
        PriceStrategy companyStrategy = new PriceStrategy(new CompanyCostomer());
        companyStrategy.quotePriceByCustomerType();
    }
}
