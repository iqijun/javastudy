package com.fullstacker.study.course.netty.discardServe;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author xgs
 * @create 2017-06-09-18:11
 **/
public class Serve {
    
    public static void main(String[] args) {
        //创建两个线程组，bossGroup负责网络连接，workerGroup负责具体处理
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //服务端辅助类 ，可以用来配置channel
            ServerBootstrap bootstrap = new ServerBootstrap();
            //绑定两个线程组
            bootstrap.group(bossGroup, workerGroup)
                    //设置channel
                    .channel(NioServerSocketChannel.class)
                    //设置handler用于处理消息，
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ServerHandler());
                        }
                    });
            //绑定端口，并返回一个channelFuture（异步）
            ChannelFuture channelFuture = bootstrap.bind(8088).sync();
            //保持线程运行，直到channel关闭
            channelFuture.channel().closeFuture().sync();
            //
            channelFuture.addListener(ChannelFutureListener.CLOSE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
