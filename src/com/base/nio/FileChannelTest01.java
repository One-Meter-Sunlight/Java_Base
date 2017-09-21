package com.base.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Describe：文件流 -> 通道 -> 缓冲区(可以写入和读取数据的内存) -> 通道
 * Created by ck 2017/9/20 11:17
 */
public class FileChannelTest01 {

    public static void readFile() {

        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile("E:/Java_Base/src/source/nio-data.txt", "r");
            // System.out.println(raf.length()); 文件的字节长度：565
            FileChannel infileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            // 写入buffer数据两种方式：1、从channel写入 2、通过Buffer的put()方法写到Buffer里
            int len = infileChannel.read(byteBuffer);
            while (len != -1) {
                System.out.println("\t ----------每次写入长度：" + len);
                // 翻转，模式切换，将Buffer从写模式切换到读模式， 并且将position值赋值给limit, position置为0，
                // limit的长度就是文件的长度, 如果这里不转换模式，get()方法将读取不到任何数据
                byteBuffer.flip();

                // 非必要，将position的位置置为0，flip()已经完成;
                byteBuffer.rewind();

                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                    //System.out.print(new String(byteBuffer.array()));
                }

                // 清空，准备再次写入;
                // byteBuffer.compact(); // 将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面。
                // limit属性依然像clear()方法一样，设置成capacity。现在Buffer准备好写数据了，但是不会覆盖未读的数据。
                byteBuffer.clear();

                // 下一次写入
                len = infileChannel.read(byteBuffer);
            }

            // 通道关闭
            infileChannel.close();
            // 文件流关闭
            randomAccessFile.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileChannelTest01.readFile();
    }
}
