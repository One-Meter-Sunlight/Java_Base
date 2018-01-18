package com.base.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 *
 * @author ck
 * @date 2018/1/11 10:38
 */
public class QQClient {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9991);
        // 输出流
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        // 输入流
        BufferedReader bt = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while (true) {
            String str = scanner.next();
            pw.println(str);
            pw.flush();

            // 接收消息
            System.out.println(bt.readLine());

            if (str.equals("exit")) {
                break;
            }
        }

        try {
            pw.close();
            bt.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
