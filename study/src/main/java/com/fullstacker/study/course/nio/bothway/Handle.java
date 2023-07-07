package com.fullstacker.study.course.nio.bothway;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author xgs
 * @create 2017-05-24-10:20
 **/
public class Handle {

    public void accept(SelectionKey key) {
        try {
            //1 获取服务通道
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            //2 执行阻塞方法
            SocketChannel sc = ssc.accept();
            //3 设置阻塞模式
            sc.configureBlocking(false);
            //4 注册到多路复用器上，并设置读取标识
            sc.register(key.selector(), SelectionKey.OP_READ);
            //            ssc.register(this.seletor, SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void read(SelectionKey key) {
        SocketChannel channel = (SocketChannel) key.channel();
        try {
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            int count = channel.read(readBuffer);
            if (count == -1) {
                key.channel().close();
                key.cancel();
                return;
            }
            //5 有数据则进行读取 读取之前需要进行复位方法(把position 和limit进行复位)
            readBuffer.flip();
            //6 根据缓冲区的数据长度创建相应大小的byte数组，接收缓冲区的数据
            byte[] bytes = new byte[readBuffer.remaining()];
            //7 接收缓冲区数据
            readBuffer.get(bytes);
            //8 打印结果
            String body = new String(bytes, "utf-8").trim();
            System.out.println(channel.getRemoteAddress() + "读取到信息 : " + body);
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(SelectionKey key, String content) {

        try {
            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer writeBuff = ByteBuffer.allocate(1024);
            writeBuff.put(content.getBytes());
            channel.write(writeBuff);
            key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
