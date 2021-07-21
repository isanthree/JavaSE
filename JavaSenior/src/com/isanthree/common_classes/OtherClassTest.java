package com.isanthree.common_classes;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 其他常用类的使用
 * 1.System
 * 2.Math
 * 3.BigInteger 和 BigDecimal
 */
public class OtherClassTest {

	@Test
	public void test1() {
		String javaVersion = System.getProperty("java.version");
		System.out.println("java的version: " + javaVersion);

		String javaHome = System.getProperty("java.home");
		System.out.println("java home: " + javaHome);

		String osName = System.getProperty("os.name");
		System.out.println("os name: " + osName);

		String osVersion = System.getProperty("os.version");
		System.out.println("os version: " + osVersion);

		String userName = System.getProperty("user.name");
		System.out.println("username: " + userName);

		String userHome = System.getProperty("user.home");
		System.out.println("user home: " + userHome);

		String userDir = System.getProperty("user.dir");
		System.out.println("user dir: " + userDir);

	}

	@Test
	public void test2() {
		BigInteger bi = new BigInteger("1243324112234324324325235245346567657653");
		BigDecimal bd = new BigDecimal("12435.351");
		BigDecimal bd2 = new BigDecimal("11");
		System.out.println(bi);
//         System.out.println(bd.divide(bd2));
		System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
		System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));
	}
}
