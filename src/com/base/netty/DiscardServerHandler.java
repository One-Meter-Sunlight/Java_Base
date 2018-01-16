package com.base.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * 抛弃服务处理器：建立抛弃规则
 *
 * @author ck
 * @date 2018/1/15 11:09
 */
public class DiscardServerHandler extends ChannelHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf byteBuf = (ByteBuf) msg;
            System.out.print(byteBuf.toString(CharsetUtil.US_ASCII));
            // ctx.writeAndFlush(msg); // 把缓冲区的数据强行输出
        } catch (Exception e) {
            throw e;
        } finally {
            // 显示的调用释放消息
            ReferenceCountUtil.release(msg);
        }
    }

    /**
     * 发生异常时触发
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
