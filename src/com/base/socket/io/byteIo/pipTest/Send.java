package com.base.socket.io.byteIo.pipTest;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 发送端
 *
 * @author ck
 * @date 2018/1/11 15:42
 */
public class Send implements Runnable {

    // 输出管道流
    PipedOutputStream pout = null;

    public Send() {
        pout = new PipedOutputStream();
    }

    public void connect(PipedInputStream pin) throws IOException {
        pout.connect(pin);
    }

    @Override
    public void run() {
        String txt = "你好，张文强";
        byte[] by = txt.getBytes();
        try {
            pout.write(by);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != pout) {
                try {
                    pout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
