package com.isanthree.network_programming;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现 TCP 的网络编程
 * 例题 3：从客户端发送文件给服务端，服务端保存到本地。并返回「发送成功」给客户端，然后关闭相应的连接。
 */
public class TCPTest3 {
    /*
     * 这里涉及到的异常，应该使用 try-catch-finally 处理
     */
    @Test
    public void client() throws IOException {
        // 1.
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),8890);
        // 2.
        OutputStream os = socket.getOutputStream();
        // 3.
        FileInputStream fis = new FileInputStream(new File("dataDir\\xiao-wukong.jpg"));
        // 4.
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        // 关闭数据的输出
        socket.shutdownOutput();

        // 5.接收来自于服务器端的数据，并显示到控制台上
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len1;
        while((len1 = is.read(buffer)) != -1){
            baos.write(buffer,0,len1);
        }

        System.out.println(baos.toString());

        // 6.
        fis.close();
        os.close();
        socket.close();
        baos.close();
    }

    /*
     * 这里涉及到的异常，应该使用 try-catch-finally 处理
     */
    @Test
    public void server() throws IOException {
        // 1.
        ServerSocket ss = new ServerSocket(8890);
        // 2.
        Socket socket = ss.accept();
        // 3.
        InputStream is = socket.getInputStream();
        // 4.
        FileOutputStream fos = new FileOutputStream(new File("dataDir\\xiao-wukong2.jpg"));
        // 5.
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        System.out.println("图片传输完成");

        // 6.服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，客户端，照片我已收到，good job！".getBytes());

        // 7.
        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();
    }
}
