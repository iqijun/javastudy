package com.fullstacker.study.course.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Client implements Runnable {
    
    //1 多路复用器（管理所有的通道）
    private Selector seletor;
    
    InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8765);
    
    ;
    
    //声明连接通道
    SocketChannel sc = null;
    
    //建立缓冲区
    ByteBuffer writeBuf = ByteBuffer.allocate(1024);
    
    ByteBuffer readBuf = ByteBuffer.allocate(1024);
    
    public Client(int port) {
        //创建连接的地址
        try {
            this.seletor = Selector.open();
            //2 打开服务器通道
            ServerSocketChannel ssc = ServerSocketChannel.open();
            //3 设置服务器通道为非阻塞模式
            ssc.configureBlocking(false);
            //4 绑定地址
            ssc.bind(new InetSocketAddress(port));
            //5 把服务器通道注册到多路复用器上，并且监听阻塞事件
            ssc.register(this.seletor, SelectionKey.OP_ACCEPT);
            
            System.out.println("=========client Server start, port==========" + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void run() {
        try {
            //打开通道
            sc = SocketChannel.open();
            //进行连接
            sc.connect(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                
                //定义一个字节数组，然后使用系统录入功能：
                byte[] bytes = new byte[1024];
                System.out.println("===========客户端请求输入===================");
                System.in.read(bytes);
                
                //把数据放到缓冲区中
                writeBuf.put(bytes);
                //对缓冲区进行复位
                writeBuf.flip();
                //写出数据
                sc.write(writeBuf);
                System.out.println("client:remoterAddress" + sc.getRemoteAddress().toString() + "::::localAddress:" + sc
                        .getLocalAddress().toString());
                //清空缓冲区数据
                writeBuf.clear();
                
                System.out.println("============客户端读取信息=================");
                this.seletor.select();
                Set<SelectionKey> selectionKeys = this.seletor.selectedKeys();
                Iterator<SelectionKey> keys = selectionKeys.iterator();
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    keys.remove();
                    if (key.isAcceptable()) {
                        this.accept(key);
                    }
                    //8 如果为可读状态
                    if (key.isReadable()) {
                        this.read(key);
                    }
                    //9 写数据
                    if (key.isWritable()) {
                        this.write(key); //ssc
                    }
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (sc != null) {
                    try {
                        sc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        new Thread(new Client(8080)).start();
    }
    
    
    private void write(SelectionKey key) {
        try {
            SocketChannel sc = (SocketChannel) key.channel();
            sc.write(writeBuf);
            writeBuf.clear();
            //写完之后就不需要再将socketChannel注册到selector上
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private void read(SelectionKey key) {
        try {
            //1 清空缓冲区旧的数据
            this.readBuf.clear();
            //2 获取之前注册的socket通道对象
            SocketChannel sc = (SocketChannel) key.channel();
            //3 读取数据
            int count = sc.read(this.readBuf);
            //4 如果没有数据
            if (count == -1) {
                key.channel().close();
                key.cancel();
                return;
            }
            //5 有数据则进行读取 读取之前需要进行复位方法(把position 和limit进行复位)
            this.readBuf.flip();
            //6 根据缓冲区的数据长度创建相应大小的byte数组，接收缓冲区的数据
            byte[] bytes = new byte[this.readBuf.remaining()];
            //7 接收缓冲区数据
            this.readBuf.get(bytes);
            //8 打印结果
            String body = new String(bytes).trim();
            System.out.println("client : " + body);
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private void accept(SelectionKey key) {
        try {
            //1 获取服务通道
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            //2 执行阻塞方法
            SocketChannel sc = ssc.accept();
            //3 设置阻塞模式
            sc.configureBlocking(false);
            //4 注册到多路复用器上，并设置读取标识
            sc.register(this.seletor, SelectionKey.OP_READ);
            //            ssc.register(this.seletor, SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
