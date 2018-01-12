package com.base.socket.io.byteIo;

import java.io.*;

/**
 * 顺序流
 *
 * @author ck
 * @date 2018/1/11 15:27
 */
public class SequenceInputStreamTest {

    public static void main(String[] args) throws Exception {
        // 输出文件流
        OutputStream os = new FileOutputStream(new File("d:/testAll.text"));
        // 输入文件流
        InputStream is1 = new FileInputStream(new File("d:/test.text"));
        InputStream is2 = new FileInputStream(new File("d:/test.text"));

        // 最多只能合并两个输入流
        SequenceInputStream sis = new SequenceInputStream(is1, is2);
        int temp = 0;
        while ((temp = sis.read()) != -1) {
            os.write(temp);
        }

        os.close();
        sis.close();
        is1.close();
        is2.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/testAll.text"));
        User u = (User) ois.readObject();
        System.out.println(u.getName());
        System.out.println(u.getAge());
        ois.close();

    }

}
