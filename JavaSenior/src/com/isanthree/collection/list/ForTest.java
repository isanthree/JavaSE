package com.isanthree.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了 foreach 循环，用于遍历集合、数组
 */
public class ForTest {

	@Test
	public void test1() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);

        /**
         * for(集合元素的类型 局部变量 : 集合对象)
         * 内部仍然调用了迭代器。
         */
		for (Object obj : coll) {
			System.out.println(obj);
		}
	}

	@Test
	public void test2() {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6};
		// for(数组元素的类型 局部变量 : 数组对象)
		for (int i : arr) {
			System.out.println(i);
		}
	}

	@Test
	public void test3() {

		String[] arr = new String[]{"MM", "MM", "MM"};

		// 方式二：增强for循环
		for (String s : arr) {  // 遍历 arr，并把元素的值赋给新的局部变量
			s = "GG";  // 不会改变 arr 中的元素
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
