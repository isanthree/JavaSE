package com.isanthree.collection.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	/**
	 * Properties：常用来处理配置文件。key 和 value 都是 String 类型
	 */
	public static void main(String[] args) {

		FileInputStream fileInputStream = null;
		try {
			Properties properties = new Properties();
			fileInputStream = new FileInputStream("jdbc.properties");
			properties.load(fileInputStream);  // 加载流对应的文件

			String name = properties.getProperty("name");
			String password = properties.getProperty("password");

			System.out.println("name = " + name + ", password = " + password);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
