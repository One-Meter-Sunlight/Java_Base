package com.base.socket.io.charIo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * URL
 *
 * @author ck
 * @date 2018/1/11 17:49
 */
public class URLTest {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.baidu.com");
        InputStream is = url.openStream();
        // 转换成字符流
        InputStreamReader isr = new InputStreamReader(is);
        int len;
        while ((len = isr.read()) != -1) {
            System.out.print((char) len);
        }
        isr.close();
        is.close();

        System.out.println("--------------------------------");

        // 或者
        InputStream is2 = url.openStream();
        // 转换成字符流
        InputStreamReader isr2 = new InputStreamReader(is2);
        BufferedReader br = new BufferedReader(isr2);
        while ((br.read()) != -1) {
            System.out.println(br.readLine());
        }
        isr2.close();
        is2.close();
    }

}
