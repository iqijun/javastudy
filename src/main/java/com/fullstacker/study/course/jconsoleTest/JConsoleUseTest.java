package com.fullstacker.study.course.jconsoleTest;

import java.util.ArrayList;
import java.util.List;

/**
 * jConsole使用测试
 * <p>
 * 示例来自《深入理解java虚拟机》
 *
 * @author xingguishuai
 * @create 2018-09-26-16:07
 **/
public class JConsoleUseTest {

    /**
     * 内存占位符对象，一个OOMObject大约占64KB
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) { //稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);

            list.add(new OOMObject());
        }
        System.gc();
        Thread.sleep(10000);
    }

    public static void main(String[] args) throws Exception {

        fillHeap(1000);

    }

}
