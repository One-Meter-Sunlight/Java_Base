package com.base.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * 时间处理器
 *
 * @author ck
 * @date 2018/1/15 15:15
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf byteBuf = ctx.alloc().buffer(4);
        byteBuf.writeLong(System.currentTimeMillis() / 1000L + 2208988800L);

        ChannelFuture future = ctx.writeAndFlush(byteBuf);
        future.addListener(f -> {
            assert future == f;
            ctx.close();
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
