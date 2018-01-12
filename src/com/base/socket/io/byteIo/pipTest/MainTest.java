package com.base.socket.io.byteIo.pipTest;

import java.io.IOException;

/**
 * 管道流
 * 必须是有两根管道相接， 发送端输出管道 连接 接收端输入管道才能通信
 *
 * @author ck
 * @date 2018/1/11 15:43
 */
public class MainTest {

    public static void main(String[] args) throws IOException {

        Recev recev = new Recev();
        Send send = new Send();
        send.connect(recev.getPin());

        Thread sendThread = new Thread(send);
        sendThread.start();

        Thread recevThread = new Thread(recev);
        recevThread.start();

    }

}
