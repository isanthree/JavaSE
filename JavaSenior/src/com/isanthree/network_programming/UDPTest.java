package com.isanthree.network_programming;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP 协议的网络编程
 */
public class UDPTest {

	// 发送端
	@Test
	public void sender() throws IOException {

		DatagramSocket socket = new DatagramSocket();

		String str = "我是以 UDP 方式发送的导弹";
		byte[] data = str.getBytes();
		InetAddress inet = InetAddress.getLocalHost();
		DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 8890);

		socket.send(packet);

		socket.close();
	}

	// 接收端
	@Test
	public void receiver() throws IOException {

		DatagramSocket socket = new DatagramSocket(8890);

		byte[] buffer = new byte[100];
		DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

		socket.receive(packet);

		System.out.println(new String(packet.getData(), 0, packet.getLength()));

		socket.close();
	}
}
