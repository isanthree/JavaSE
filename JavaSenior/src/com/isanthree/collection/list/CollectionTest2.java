package com.isanthree.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection 接口中声明的方法的测试
 *
 * 结论：
 * 向 Collection 接口的实现类的对象中添加数据 obj 时，要求 obj 所在类要重写 equals().
 */
public class CollectionTest2 {
	@Test
	public void test1() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);

		// 1.contains(Object obj)：判断当前集合中是否包含obj
		// 我们在判断时会调用 obj 对象所在类的 equals()
		boolean contains = coll.contains(123);
		System.out.println("比较数字：" + contains);
		System.out.println("比较字符串：" + coll.contains(new String("Tom")));  // true

		/*
		 * 结果输出：false（重写 equals() 前） --> true（重写 equals() 后）
		 * 调用三次 equals() 分别比较 「123」、「456」、「Person("Jerry", 20)」，
		 * 才找到 Person("Jerry", 20)，所以将会打印三次 "Person equals()...."
		 */
		System.out.println("比较 Person 类对象：" + coll.contains(new Person("Jerry", 20)));  // false --> true

		// 2.containsAll(Collection coll1)：判断形参 coll1 中的所有元素是否都存在于当前集合中
		Collection coll1 = Arrays.asList(123, 4567);
		System.out.println(coll.containsAll(coll1));
	}

	@Test
	public void test2() {
		// 3.remove(Object obj)：从当前集合中移除 obj 元素。
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);

		boolean rmFlg = coll.remove(1234);
		System.out.println("删除 1234 结果：" + rmFlg);
		System.out.println("打印 coll 对象的全部元素：" + coll);

		coll.remove(new Person("Jerry", 20));
		System.out.println("删除 Person(\"Jerry\", 20) 后所剩元素：" + coll);

		// 4.removeAll(Collection coll1):差集：从当前集合中移除coll1中所有的元素。
		Collection coll1 = Arrays.asList(123, 456);
		coll.removeAll(coll1);
		System.out.println("删除 (123, 456) 后所剩元素：" + coll);
	}

	@Test
	public void test3() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);

		// 5.retainAll(Collection coll1)：交集：获取当前集合和 coll1 集合的交集，并返回给当前集合
        Collection coll1 = Arrays.asList(123,456,789);
        coll.retainAll(coll1);
        System.out.println("求交集后：" + coll);

		// 6.equals(Object obj)：要想返回 true，需要当前集合和形参集合的元素都相同。原因在于 ArrayList 是有序的
		Collection coll2 = new ArrayList();
		coll2.add(123);
		coll2.add(456);
		coll2.add(new Person("Jerry", 20));
		coll2.add(new String("Tom"));
		coll2.add(false);

		Collection coll3 = new ArrayList();
		coll3.add(123);
		coll3.add(456);
		coll3.add(new Person("Jerry", 20));
		coll3.add(new String("Tom"));
		coll3.add(false);

		System.out.println("coll2 集合和 coll3 集合比较结果：" + coll2.equals(coll3));  // 添加顺序完全一致才返回 true
	}

	@Test
	public void test4() {
		Collection coll = new ArrayList();
		coll.add(123);
		coll.add(456);
		coll.add(new Person("Jerry", 20));
		coll.add(new String("Tom"));
		coll.add(false);

		// 7.hashCode()：返回当前对象的哈希值
		System.out.println("coll 对象的哈希值：" + coll.hashCode());

		// 8.集合 --->数组：toArray()
		Object[] arr = coll.toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println("coll 转数组后，arr[" + i + "]：" + arr[i]);
		}

		// 拓展：数组 ---> 集合：调用 Arrays 类的静态方法 asList()
		List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
		System.out.println(list);

		List arr1 = Arrays.asList(new int[]{123, 456});
		System.out.println(arr1.size());  // 1

		List arr2 = Arrays.asList(new Integer[]{123, 456});
		System.out.println(arr2.size());  // 2
	}
}
