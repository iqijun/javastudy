package com.fullstacker.study.study.designpattern.singleton;

/**
 * 利用单元素的枚举类型实现单例
 * <p>
 * 这种方法在更加简洁，并且无偿地提供了序列化机制，即使是面对复杂的序列化或者反射攻击时，也绝对防止多次实例化
 * 《effective java》中讲单元素的枚举类型已成为实现Singleton的最佳方法
 */
class Resource {
    //这个是要保证单例的资源类

}

public enum EnumSingleton {
    INSTANCE;
    private Resource resource;

    /**
     * <p>功能描述：这是这个枚举类的构造方法，它天然是私有的外部不能访问</p>
     *
     * @author: xgs
     * @Date: 2019-08-31 15:55
     * @ return
     * @since 1.0
     */
    EnumSingleton() {
        resource = new Resource();
    }

    public Resource getInstance() {
        return resource;
    }

    public static void main(String[] args) {
        System.out.println(EnumSingleton.INSTANCE.getInstance() == EnumSingleton.INSTANCE.getInstance());
    }
}
