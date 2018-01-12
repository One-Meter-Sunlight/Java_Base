package com.base.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务端
 *
 * @author ck
 * @date 2018/1/11 10:38
 */
public class QQServer {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // 接收
        ServerSocket server = new ServerSocket(9991);
        Socket s = server.accept();  // 阻塞方法
        System.out.println("连接成功：" + s.getRemoteSocketAddress());
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        // 发送
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
        while (true) {

            // 因为BIO都是阻塞IO所以这里一定要收到信息才能继续往下走
            System.out.println(br.readLine());

            String str = scanner.next();
            pw.println(str);
            pw.flush();

            if (str.equals("exit")) {
                break;
            }
        }

        try {
            pw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}