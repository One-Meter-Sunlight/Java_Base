package com.base.socket.io.byteIo;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 缓冲流
 *
 * @author ck
 * @date 2018/1/11 17:28
 */
public class BufferStreamTest {

    public static void main(String[] args) throws Exception {
        String name = "江涛";
        InputStream is = new ByteArrayInputStream(name.getBytes());
        BufferedInputStream bis = new BufferedInputStream(is);
        int len;
        byte[] by = new byte[name.getBytes().length];
        while ((len = bis.read(by)) != -1) {
            System.out.print(new String(by));
        }
        bis.close();
    }

}
