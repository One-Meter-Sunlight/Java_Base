package com.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Describe：服务器
 * epoll 多路复用IO， 轮询
 * 模型：一栋楼的住户都点了外卖，但是每个人不用下楼去看外卖小哥到了没有，物业把这个事情交给门卫小哥，当外卖送过来的时候的，
 * 首先会给门卫小哥，门卫小哥再通知住户去拿，这样就把等待的工作交给门卫小哥了，其他住户该干嘛就可以干嘛，这里面有一种异步的思想；
 *
 * Created by ck 2017/9/21 14:23
 */
public class EpollServer {

    public static void main(String[] args) {

        try {
            // 打开服务器Socket通道
            ServerSocketChannel ssc = ServerSocketChannel.open();
            // 得到socket并且绑定网络地址和端口
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 9091));
            // 设置非阻塞
            ssc.configureBlocking(false);

            Selector selector = Selector.open();
            // 注册Selector，并指定感兴趣的事件
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(128);
            writeBuffer.put("received".getBytes("utf-8"));
            // 切换模式
            writeBuffer.flip();

            while (true) {
                int nReady = selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> ite = keys.iterator();

                while (ite.hasNext()) {
                    SelectionKey key = ite.next();
                    ite.remove();

                    if (key.isAcceptable()) {
                        // 创建新的连接，并把连接注册到selector上，并且声明这个channel只对读感兴趣
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false); // 非阻塞
                        socketChannel.register(selector, SelectionKey.OP_READ);

                    } else if(key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        readBuffer.clear();
                        socketChannel.read(readBuffer);

                        readBuffer.flip();
                        System.out.println("received : " + new String(readBuffer.array()));
                        key.interestOps(SelectionKey.OP_WRITE);

                    } else if (key.isWritable()) {
                        writeBuffer.rewind(); // 重置position的位置为0
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        socketChannel.write(writeBuffer);

                        key.interestOps(SelectionKey.OP_READ);  // ?
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
