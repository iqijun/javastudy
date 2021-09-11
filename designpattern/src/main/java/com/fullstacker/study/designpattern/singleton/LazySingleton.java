package com.fullstacker.study.designpattern.singleton;

/**
 * 懒汉模式
 *
 * @author xgs
 * @create 2017-03-27-15:58
 **/
public class LazySingleton {
    private static LazySingleton intance;

    private LazySingleton() {

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
    public static LazySingleton getIntance() {
        if (null == intance) {
            intance = new LazySingleton();
        }
        return intance;
    }

    /**
     * <p>功能描述：判断是否存在存在实例，如果不存在则，创建对象
     * 此时，否则返回实例，同步方式获取，但粒度较大，效率较低，可以使用双重判断的方法以优化</p>
     *
     * @param
     * @return
     * @author xgs
     * @Date 2017-03-27 15:59
     * @since 1.0
     */
    public static synchronized LazySingleton getIntanceSyn() {
        if (null == intance) {
            intance = new LazySingleton();
        }
        return intance;
    }

}
