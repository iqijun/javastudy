package com.fullstacker.study.study.designpattern.singleton;

/**
 * 双重判断法
 *
 * @author xgs
 * @create 2017-03-27-16:06
 **/
public class DubbleSingleton {
    private static DubbleSingleton intance;

    private DubbleSingleton() {

    }

    /**
     * <p>功能描述：判断是否存在存在实例，如果不存在则，创建对象
     * 此时，否则返回实例，为线程不安全</p>
     *
     * @param
     * @return
     * @author xgs
     * @Date 2017-03-27 15:59
     * @since 1.0
     */
    public static DubbleSingleton getIntance() {
        //第一次检验是否为null
        if (null == intance) {
            try {
                //模拟生成对象前准备
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //同步代码块
            synchronized (DubbleSingleton.class) {
                //创建对象前，再次校验是否为null
                if (null == intance) {
                    intance = new DubbleSingleton();
                }
            }
        }
        return intance;
    }

}
