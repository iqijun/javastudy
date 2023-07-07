package com.fullstacker.study.course.nio.bothway;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * 客户端
 *
 * @author xgs
 * @create 2017-05-24-10:21
 **/
public class Client {

    private Selector selector;

    private SocketChannel socketchannel;

    private String hostIp;

    private int port;

    /**
     * 构造函数
     *
     * @param hostIp
     * @param port
     * @throws IOException
     */
    public Client(String hostIp, int port) throws IOException {
        this.hostIp = hostIp;
        this.port = port;
        //打开并注册到信道
        selector = Selector.open();

        initializeClient();
        //        initializeServe(8887);
    }

    public void initializeServe(int port) throws IOException {
        //1 打开路复用器
        this.selector = Selector.open();
        //2 打开服务器通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //3 设置服务器通道为非阻塞模式
        ssc.configureBlocking(false);
        ServerSocketChannel bind = ssc.bind(new InetSocketAddress(port));
        //5 把服务器通道注册到多路复用器上，并且监听阻塞事件
        ssc.register(this.selector, SelectionKey.OP_ACCEPT);

    }

    /**
     * 初始化
     *
     * @throws IOException
     */
    public void initializeClient() throws IOException {
        //打开监听信道并设置为非阻塞模式
        socketchannel = SocketChannel.open(new InetSocketAddress(hostIp, port));
        socketchannel.configureBlocking(false);
        socketchannel.register(selector, SelectionKey.OP_READ);
        //启动读线程
        //        Runnable runnable = new Runnable() {
        //            Handle handle = new Handle();
        //            @Override
        //            public void run() {
        //
        //                try {
        //                    while(selector.select()>0){
        //                        for(SelectionKey key:selector.selectedKeys()){
        //                            if(key.isReadable()){
        //                                handle.read(key);
        //                                //删除正在处理的selectionkey
        //                                selector.selectedKeys().remove(key);
        //                            }
        //
        //                        }
        //
        //                    }
        //                } catch (IOException e) {
        //                    e.printStackTrace();
        //                }
        //            }
        //        };
        //        new Thread(runnable).start();
    }

    public void sendMsg(String message) throws IOException {
        ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes("UTF-8"));
        socketchannel.write(writeBuffer);
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.1", 8888);
        Scanner read = new Scanner(System.in);
        while (true) {
            System.out.println("本地:");
            String msg = read.next();
            client.sendMsg(msg);
        }

    }
}
