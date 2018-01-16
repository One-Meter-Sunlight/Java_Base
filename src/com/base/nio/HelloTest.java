package com.base.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

import java.awt.*;

/**
 * Netty 第一节课
 *
 * @author ck
 * @date 2018/1/15 10:02
 */
public class HelloTest {

    public static void main(String[] args) {

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();


    }

}
