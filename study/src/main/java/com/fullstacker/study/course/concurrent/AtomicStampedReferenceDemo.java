package com.fullstacker.study.course.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {

    static User user1 = new User("zhangsan", 10);

    static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(user1, 1);

    public static void main(String[] args) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "获得版本号：" + atomicStampedReference.getStamp());

                try {
//                    睡1秒保证线程T2可以获取到相同的版本号
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                User lisi = new User("lisi", 12);

                atomicStampedReference.compareAndSet(user1, lisi, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                System.out.println("t1将user修改为lisi，版本号："+ atomicStampedReference.getStamp());
                atomicStampedReference.compareAndSet(lisi, user1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);

                System.out.println(Thread.currentThread().getName() + "修改完成，" +
                        "最终值为：" + atomicStampedReference.get(new int[]{atomicStampedReference.getStamp()})
                        + "版本号为" + atomicStampedReference.getStamp());
            }
        }, "t1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "获得版本号：" + atomicStampedReference.getStamp());

                try {
//                    睡1秒保证线程T1可以完成1个ABA修改
                    System.out.println("t2 休眠3s");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("t2 睡醒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                User wangwu = new User("wangwu", 12);

                boolean isSuccess = atomicStampedReference.compareAndSet(user1, wangwu, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);


                System.out.println(Thread.currentThread().getName() + "修改完成，修改结果为" + isSuccess +
                        "最终值为：" + atomicStampedReference.get(new int[]{atomicStampedReference.getStamp()})
                        + "版本号为" + atomicStampedReference.getStamp());
            }
        }, "t2").start();

    }

}
