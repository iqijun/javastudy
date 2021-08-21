package com.fullstacker.study.interview;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * 国美面试题，三个线程依次读取字符串中的n个字符，并输出
 * 同PrintThreadTest.java
 *
 * @author xgs
 * @create 2017-03-07-10:03
 **/
public class ReadString {
    /**
     * 读取计数
     */
    private int count = 0;

    private String string;
    /**
     * 字符串被读取的次数
     */
    private AtomicInteger readTime = new AtomicInteger(0);

    public ReadString(String string) {
        this.string = string;
    }

    public ReadString() {
    }

    /**
     * <p>功能描述：</p>
     *
     * @param string  需要被读取的字符串
     * @param readNum 每次读取的个数
     * @return
     * @author xgs
     * @Date 2017-03-07 10:17
     * @since 1.0
     */
    public void read(int readNum) {
        int length = string.length();
        synchronized (string) {
            System.out.println(Thread.currentThread().getName() + ":" + string.substring(count, count + readNum > length ? length : count + readNum));
            count += readNum;
            readTime.incrementAndGet();
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public AtomicInteger getReadTime() {
        return readTime;
    }

    public void setReadTime(AtomicInteger readTime) {
        this.readTime = readTime;
    }

    public static void main(String[] args) {
        String string = "abcdefghijklmnopqrstuvwxyz";
        final ReadString readString = new ReadString(string);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (readString.getReadTime().get() % 3 == 0) {
                        readString.read(3);
                    } else if (readString.getCount() > readString.getString().length()) {
                        break;
                    }
                }
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (readString.getReadTime().get() % 3 == 1) {
                        readString.read(3);
                    } else if (readString.getCount() > readString.getString().length()) {
                        break;
                    }
                }
            }
        }, "t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (readString.getReadTime().get() % 3 == 2) {
                        readString.read(3);
                    } else if (readString.getCount() > readString.getString().length()) {
                        break;
                    }
                }
            }
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
    }


}
