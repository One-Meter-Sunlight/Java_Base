package com.base.socket.io.byteIo.pipTest;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 接收方
 *
 * @author ck
 * @date 2018/1/11 15:45
 */
public class Recev implements Runnable {

    // 输出管道流
    PipedInputStream pin = null;

    public Recev() {
        pin = new PipedInputStream();
    }

    public PipedInputStream getPin() {
        return pin;
    }

    @Override
    public void run() {
        try {
            int tem;
            byte[] by = new byte[1024];
            tem = pin.read(by);  // 实际读的字节数
            System.out.println("接收的内容：" + new String(by, 0, tem));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != pin) {
                try {
                    pin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
