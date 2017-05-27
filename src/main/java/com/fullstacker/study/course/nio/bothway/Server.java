package com.fullstacker.study.course.nio.bothway;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * NIO服务端
 *
 * @author xingguishuai
 * @create 2017-05-24-10:21
 **/
public class Server implements  Runnable{

    private ServerSocketChannel ssc = null;

    private InetSocketAddress address = null;

    private  Selector selector = null;

    private  SocketChannel socketChannel;
    public Server(int port){
        try {
            //1 打开路复用器
            this.selector = Selector.open();
            //2 打开服务器通道
            ssc = ServerSocketChannel.open();
            //3 设置服务器通道为非阻塞模式
            ssc.configureBlocking(false);
            //4 绑定地址
            address = new InetSocketAddress(port);
            ServerSocketChannel bind = ssc.bind(address);
            //5 把服务器通道注册到多路复用器上，并且监听阻塞事件
            ssc.register(this.selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Handle handle = new Handle();

        while(true){
            try {
                //1 必须要让多路复用器开始监听
                this.selector.select();
                //2 返回多路复用器已经选择的结果集
                Iterator<SelectionKey> keys = this.selector.selectedKeys().iterator();

                //3 进行遍历
                while(keys.hasNext()){
                    //4 获取一个选择的元素
                    SelectionKey key = keys.next();
                    //5 直接从容器中移除就可以了
                    keys.remove();
                    //6 如果是有效的
                    if(key.isValid()){
                        //7 如果为阻塞状态
                        if(key.isAcceptable()){
                            handle.accept(key);
                        }
                        //8 如果为可读状态
                        if(key.isReadable()){
                            handle.read(key);
                            socketChannel = (SocketChannel) key.channel();
                        }
                        //9 写数据
                        if(key.isValid() && key.isWritable()){
                            handle.write(key,"这是服务器发出的信息");
                        }
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsg(String message)throws IOException{
        ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes("UTF-8"));
        socketChannel.write(writeBuffer);
    }
    public static void main(String[] args) throws IOException {
        Server server = new Server(8888);
        new Thread(server).start();

        Scanner read = new Scanner(System.in);
        while(true){
            System.out.println("服务:");
            String msg = read.next();
            server.sendMsg(msg);
        }
    }

}
