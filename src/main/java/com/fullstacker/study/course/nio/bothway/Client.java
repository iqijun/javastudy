package com.fullstacker.study.course.nio.bothway;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * 客户端
 *
 * @author xingguishuai
 * @create 2017-05-24-10:21
 **/
public class Client {
    private Selector selector;
    SocketChannel socketchannel;
    private String hostIp;
    private int port;
    /**
     * 构造函数
     * @param hostIp
     * @param port
     * @throws IOException
     */
    public Client (String hostIp,int port)throws IOException {
        this.hostIp = hostIp;
        this.port = port;

        initialize();
    }
    /**
     * 初始化
     * @throws IOException
     */
    public void initialize()throws IOException{
        //打开监听信道并设置为非阻塞模式
        socketchannel = SocketChannel.open(new InetSocketAddress(hostIp,port));
        socketchannel.configureBlocking(false);
        //打开并注册到信道
        selector = Selector.open();
        socketchannel.register(selector, SelectionKey.OP_READ);
        //启动读线程
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                try {
                    while(selector.select()>0){
                        for(SelectionKey key:selector.selectedKeys()){
                            if(key.isReadable()){
                                //使用NIO读取channel中的数据
                                SocketChannel clientchannel = (SocketChannel)key.channel();
                                ByteBuffer buffer = ByteBuffer.allocate(1024);
                                clientchannel.read(buffer);
                                buffer.flip();
                                String receivedString = Charset.forName("UTF-8").newDecoder().decode(buffer).toString();
                                if(StringUtils.isNotEmpty(receivedString)){
                                    System.out.println(receivedString.length());
                                    System.out.println("服务器"+clientchannel.socket().getRemoteSocketAddress()+":"+receivedString);
                                    //为下次读取准备
                                    key.interestOps(SelectionKey.OP_READ);
                                    break;
                                }
                            }
                            //删除正在处理的selectionkey
                            selector.selectedKeys().remove(key);
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
    }

    public void sendMsg(String message)throws IOException{
        ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes("UTF-8"));
        socketchannel.write(writeBuffer);
    }
    public static void main(String[] args)throws IOException{
        Client client = new Client("127.0.0.1",8888);
        Scanner read = new Scanner(System.in);
        while(true){
            System.out.println("本地:");
            String msg = read.next();
            client.sendMsg(msg);
        }

    }
}
