package com.fullstacker.study.course.netty.discardServe;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @author xingguishuai
 * @create 2017-06-09-18:13
 **/
public class ServerHandler  extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf buf = (ByteBuf) msg;
            System.out.println("buf.capacity():::"+buf.capacity());
            System.out.println("buf.readableBytes():::"+buf.readableBytes());
            byte[] bytes = new byte[buf.readableBytes()];
            buf.readBytes(bytes);
            System.out.println("server:"+new String(bytes));
            ctx.writeAndFlush(Unpooled.wrappedBuffer("洞拐已收到".getBytes()));
        } finally {
            //释放消息，否则会造成内存泄漏
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
