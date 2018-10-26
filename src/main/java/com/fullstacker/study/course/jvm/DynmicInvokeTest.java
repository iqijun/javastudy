package com.fullstacker.study.course.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class DynmicInvokeTest {

    class GrandFather{
        void print(String str){
            System.out.println("I am GrandFather");
        }
    }

    class Father extends GrandFather{
        void print(){
            System.out.println("I am Father");
        }
    }

    class Son extends  Father{
        void print(){
            //在此处实现调用GrandFather类中print方法
            MethodType mt = MethodType.methodType(void.class,String.class);
            try {
                MethodHandle methodHandle = MethodHandles.lookup().findSpecial(GrandFather.class, "print", mt, getClass());
                methodHandle.invoke(this,"sss");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

    }

    public static  void main(String[] args){
        (new DynmicInvokeTest().new Son()).print();
    }
}
