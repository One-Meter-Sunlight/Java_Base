package com.base.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Describe：客户端
 *
 * Created by ck 2017/9/21 16:23
 */
public class EpollClient {

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9091));

            ByteBuffer writeBuffer = ByteBuffer.allocate(32);
            ByteBuffer readBuffer = ByteBuffer.allocate(32);

            // 将hello写入读缓冲区
            writeBuffer.put("hello".getBytes("utf-8"));
            // 转换模式 写->读
            writeBuffer.flip();

            while (true) {
                writeBuffer.rewind();
                socketChannel.write(writeBuffer);
                readBuffer.clear();
                socketChannel.read(readBuffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
