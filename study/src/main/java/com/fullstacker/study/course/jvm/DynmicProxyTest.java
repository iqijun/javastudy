package com.fullstacker.study.course.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynmicProxyTest {
    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("Hello world");
        }
    }

    static class DynamicProxy implements InvocationHandler {

        Object originalObj;

        Object bind(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            Object invoke = method.invoke(originalObj, args);
            return invoke;
        }

    }

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        System.out.println("userDir:" + userDir);
        //动态代理生成的类默认保存在user.dir目录中，如果该目录不存在需要手动创建，否则会报fileNotFundException
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        DynmicProxyTest.DynamicProxy dynamicProxy = new DynmicProxyTest.DynamicProxy();

        DynmicProxyTest.IHello hello = (DynmicProxyTest.IHello) dynamicProxy.bind(new DynmicProxyTest.Hello());


        hello.sayHello();


    }
}
