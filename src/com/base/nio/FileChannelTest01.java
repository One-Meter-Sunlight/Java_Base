package com.base.nio;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Describe：
 * Created by ck 2017/9/20 11:17
 */
public class FileChannelTest01 {

    public static void main(String[] args) throws Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("E:/Java_Base/src/source/nio-data.txt", "rw");
        // System.out.println(raf.length()); 文件的字节长度：565
        FileChannel infileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        int len = infileChannel.read(byteBuffer);
        while (len != -1) {
            System.out.println("\t ----------每次读取长度：" + len);
            // 翻转，模式切换，将读模式切换到写模式， 并且将position值赋值给limit, position置为0，limit的长度就是文件的长度
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }

            // 清空
            byteBuffer.clear();

            len = infileChannel.read(byteBuffer);

        }

        // 通道关闭
        infileChannel.close();
        // 文件流关闭
        randomAccessFile.close();

    }
}
