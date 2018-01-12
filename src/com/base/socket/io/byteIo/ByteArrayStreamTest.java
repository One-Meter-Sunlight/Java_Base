package com.base.socket.io.byteIo;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 内存流
 *
 * @author ck
 * @date 2018/1/11 17:18
 */
public class ByteArrayStreamTest {

    public static void main(String[] args) throws IOException {
        String name = "李院长,你好！";
        ByteArrayInputStream bit = new ByteArrayInputStream(name.getBytes());
        ByteArrayOutputStream bot = new ByteArrayOutputStream();
        int len;
        while ((len = bit.read()) != -1) {
            char c = (char) len;
            bot.write(Character.toLowerCase(c));
        }
        System.out.println(bot.toString());

        bot.close();
        bit.close();
    }

}
