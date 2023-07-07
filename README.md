# java常用技术学习

一、 并发知识

1. Atomic使用
2.

二、 NIO

- 实现了客户端向服务端发送信息；
- 服务端和客户端双向通信暂未实现
  [参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/nio)

三、java基础

1.
string.intern [参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/JAVASE/string/StringInternTest)

四、 反射

- 简单示例
  [参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/reflect)

五、 jvm相关

1. jConsole使用示例
   [参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/jconsoleTest)
2. classLoader示例
   [参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/jvm/ClassLoaderTest.java)
3. 类初始化(clinit)示例
   [参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/jvm/ClinitTest.java)
4. 动态代理示例
   [参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/jvm/DynmicProxyTest.java)

   需要注意的是在使用System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true")
   ;保存生成的动态代理类时，代理类默认保存在user.dir目录中， 如果目录不存在需要手动创建否则会产生FileNotFundException
5. if条件编译
   [参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/jvm/IfComplieTest.java)

   在编译期间就会执行if判断去除掉不能到达的条件分支 ，因此编译后这个条件分支会消失

六、常见算法实现    
1.
快速排序  [参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/com.fullstacker.study.algorithm/QuickSort.java)

七、多线程相关

1.
CountDownLatch使用示例[参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/concurrent/CountDownLatchTest.java)
2.
CyclicBarrier使用示例    [参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/concurrent/CyclicBarrierTest.java)
3.
Semaphore使用示例    [参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/concurrent/SemaphoreTest.java)
4.
多条件锁的使用示例    [参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/concurrent/ReentrantLockDemo.java)
5.
Atomic原子引用使用示例[参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/concurrent/AtomicRefDemo.java)
5.
带stamp的原子引用使用示例[参考代码](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/course/concurrent/AtomicStampedReferenceDemo.java)

# java面试题记录

一、 国美面试题，三个线程依次读取字符串中的n个字符，并输出

1. printThreadTest.java
2. ReadString.java

二、 linkedBlockingQueue使用示例

1. LinkedBlockingQueue是一个阻塞队列

# 设计模式

一、单例模式

1.[饿汉模式](https://github.com/iqijun/javastudy/tree/master/src/main/java/com/fullstacker/study/designpattern/singleton)

2.懒汉模式UGV

3.双重检验方式（懒汉模式）

4.详细介绍见[博客](http://www.full-stacker.com/archives/256)

5.利用单元素枚举类实现单例

二、Future模式

- [博客](http://www.full-stacker.com/archives/271)

三、master-woker模式

- [博客](http://www.full-stacker.com/archives/274)

四、生产者消费者模式

- [博客](http://www.full-stacker.com/archives/279)

# netty

一、hello world

1.
实现了服务端与客户端双向通信 [参考代码](https://github.com/iqijun/javastudy/tree/b47bb5c04988c61e660e20c548874ae960211df4/src/main/java/com/fullstacker/study/course/netty/discardServe)
