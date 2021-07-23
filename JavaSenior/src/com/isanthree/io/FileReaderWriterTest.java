package com.isanthree.io;

import org.junit.Test;

import java.io.*;


public class FileReaderWriterTest {

	public static void main(String[] args) {
		File file = new File("JavaSenior\\dataDir\\hello.txt");  // main() 里面：基于整个工程的根目录
		System.out.println(file.getAbsolutePath());
	}

	/**
	 * 将 hello.txt 文件内容读入程序中，并输出到控制台
	 */
	@Test
	public void fileReaderTest() {

		/*
		 * 异常处理：为了保证流资源一定可以执行关闭操作，需要使用 try-catch-finally 处理
		 */
		FileReader fileReader = null;
		try {
			// 1.实例化 File 类对象，指明要操作的对象
			File file = new File("dataDir\\hello.txt");  // fileReaderTest() 里面：基于当前模块的根目录
			System.out.println(file.getAbsolutePath());

			// 2.提供具体的流
			fileReader = new FileReader(file);

			// 3.开始数据的读入（一个字符一个字符地读）
			// 文件中字符是以 int 类型的存储的，读取的时候返回的是 int 类型的数据
			int data;
			while ((data = fileReader.read()) != -1) {
				System.out.print((char) data);  // 需要类型转换
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.流的关闭
			try {
				if (fileReader != null)
					fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 对 read() 操作升级：使用 read 的重载方法
	 */
	@Test
	public void FileReader1Test() {
		FileReader fileReader = null;
		try {
			// 1.File 类的实例化
			File file = new File("dataDir\\hello.txt");

			// 2.FileReader 的实例化
			fileReader = new FileReader(file);

			// 3.读入操作（一段段地读）：
			// read(char[] buf)：返回每次读入 buf 数组中的字符的个数
			char[] buf = new char[5];
			int len;
			while ((len = fileReader.read(buf)) != -1) {
//				// 打印方法一：
//				for (int i = 0; i < len; i++) {
//					System.out.print(buf[i]);
//				}

				// 打印方法二：
				String str = new String(buf, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 4.资源的关闭
				if (fileReader != null)
					fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 从内存中写数据到文件中
	 * 说明：
	 * 1.输出操作，对应的 File 可以不存在的。并不会报异常
	 * 2.File 对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
	 * File 对应的硬盘中的文件如果存在：
	 * 如果流使用的构造器是：FileWriter(file,false) / FileWriter(file)，将会对原有文件进行覆盖
	 * 如果流使用的构造器是：FileWriter(file,true)：将不会对原有文件覆盖，而是在原有文件基础上追加内容
	 */
	@Test
	public void fileWriterTest() {
		FileWriter fileWriter = null;
		try {
			// 1.创建 File 类对象，指明写出到的文件
			File file = new File("dataDir\\hello1.txt");

			// 2.创建 FileWriter 的对象，用于数据的写入
			fileWriter = new FileWriter(file);

			// 3.写入到文件操作
			fileWriter.write("Hello\nWorld!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 4.资源的关闭
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读入一个文件，并输出到另外一个问价
	 */
	@Test
	public void fileReaderFileWriterTest() {
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		try {
			// 1.创建 File 类对象，指明读入、输出的文件
			File fileToRead = new File("dataDir\\hello.txt");
			File fileToWrite = new File("dataDir\\hello2.txt");

			// 2.创建输入流、输出流对象
			fileReader = new FileReader(fileToRead);
			fileWriter = new FileWriter(fileToWrite, true);

			// 3.读文件操作及写文件操作
			char[] buf = new char[5];
			String str = "";
			int len;
			while ((len = fileReader.read(buf)) != -1) {
				// 写入方式一：
//				str = new String(buf, 0, len);
//				fileWriter.write(str);

				// 写入方式二：
				fileWriter.write(buf, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {  // 4.关闭资源
			try {
				if (fileReader != null)
					fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
