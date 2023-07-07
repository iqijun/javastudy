package com.fullstacker.study.course.netty.discardServe;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author xgs
 * @create 2017-06-09-18:12
 **/
public class Client {
    
    public static void main(String[] args) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    });
            
            //        ChannelFuture channelFuture = bootstrap.bind(8088).sync();
            //        channelFuture.channel().closeFuture().sync();
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8088);
            channelFuture.channel().writeAndFlush(Unpooled.wrappedBuffer("tomcat".getBytes()));
            //保持线程
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
