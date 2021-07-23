package com.isanthree.network_programming;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现 TCP 的网络编程
 * 例题 2：客户端发送文件给服务端，服务端将文件保存在本地。
 */
public class TCPTest2 {

	/**
	 * 这里涉及到的异常，应该使用 try-catch-finally 处理
	 */
	@Test
	public void client() throws IOException {
		// 1.
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8890);
		// 2.
		OutputStream os = socket.getOutputStream();
		// 3.
		FileInputStream fis = new FileInputStream(new File("dataDir\\xiao-wukong.jpg"));
		// 4.
		byte[] buffer = new byte[1024];
		int len;
		while ((len = fis.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		// 5.
		fis.close();
		os.close();
		socket.close();
	}

	/**
	 * 这里涉及到的异常，应该使用 try-catch-finally 处理
	 */
	@Test
	public void server() throws IOException {
		// 1.造 ServerSocket
		ServerSocket ss = new ServerSocket(8890);
		// 2.获取客户端 socket
		Socket socket = ss.accept();
		// 3.获取客户端输入流
		InputStream is = socket.getInputStream();
		// 4.保存数据到本地的输出流
		FileOutputStream fos = new FileOutputStream(new File("dataDir\\xiao-wukong2.jpg"));
		// 5.读取输入流，并输出到本地的 dataDir\xiao-wukong2.jpg
		byte[] buffer = new byte[1024];
		int len;
		while ((len = is.read(buffer)) != -1) {
			fos.write(buffer, 0, len);
		}
		// 6.关闭资源
		fos.close();
		is.close();
		socket.close();
		ss.close();
	}
}
