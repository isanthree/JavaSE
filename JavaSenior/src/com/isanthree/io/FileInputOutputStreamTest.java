package com.isanthree.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试 FileInputStream 和 FileOutputStream 的使用
 *
 * 结论：
 * 1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * 2. 对于非文本文件(.jpg, .mp3, .mp4, .avi, .doc, .ppt, ...)，使用字节流处理
 */
public class FileInputOutputStreamTest {
	/**
	 * 使用字节流 FileInputStream 处理文本文件，可能出现乱码。
	 * 原因：byte[5] 可能存不下多个中文字符。在 Java 中，一个中文字符对应三个字节
	 */
	@Test
	public void testFileInputStream() {
		FileInputStream fis = null;
		try {
			// 1.造文件
			File file = new File("dataDir\\hello.txt");

			// 2.造流
			fis = new FileInputStream(file);

			// 3.读数据
			byte[] buffer = new byte[5];
			int len;  // 记录每次读取的字节的个数
			while ((len = fis.read(buffer)) != -1) {
				String str = new String(buffer, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				// 4.关闭资源
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 实现对图片的复制操作
	 */
	@Test
	public void testFileInputOutputStream() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 1.造文件
			File srcFile = new File("dataDir\\xiao-wukong.jpg");
			File destFile = new File("dataDir\\xiao-wukong2.jpg");

			// 2.造流
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);

			// 3.读写过程（复制）
			byte[] buffer = new byte[5];
			int len;
			while ((len = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4.关闭资源
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 指定路径下文件的复制
	 */
	public void copyFile(String srcPath, String destPath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			// 1.造文件
			File srcFile = new File(srcPath);
			File destFile = new File(destPath);

			// 2.造流
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(destFile);

			// 3.读写过程（进行复制）
			byte[] buffer = new byte[1024];
			int len;
			while ((len = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				// 4.关闭资源
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testCopyFile() {

		long start = System.currentTimeMillis();

		String srcPath = "E:\\lenovo\\Desktop\\test.mp4";
		String destPath = "E:\\lenovo\\Desktop\\test-copy.mp4";

//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";

		copyFile(srcPath, destPath);

		long end = System.currentTimeMillis();

		System.out.println("复制操作花费的时间为：" + (end - start) + "ms");
	}
}
