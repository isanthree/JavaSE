package com.isanthree.common_classes.enumeration;

import org.junit.Test;

/**
 * 一、枚举类的使用
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
 * <p>
 * 二、如何定义枚举类
 * 方式一：jdk5.0 之前，自定义枚举类
 * 方式二：jdk5.0，可以使用 enum 关键字定义枚举类
 * <p>
 * 三、Enum类中的常用方法：
 * values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 * valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。
 * toString()：返回当前枚举类对象常量的名称
 * <p>
 * 四、使用enum关键字定义的枚举类实现接口的情况
 * 情况一：实现接口，在enum类中实现抽象方法
 * 情况二：让枚举类的对象分别实现接口中的抽象方法
 */
public class SeasonTest {

	@Test
	public void myEnumClassTest() {
		Season spring = Season.SPRING;
		System.out.println(spring);
	}

	@Test
	public void enumClassTest() {
		Season1 summer = Season1.SUMMER;
		// toString()：返回枚举类对象的名称
		System.out.println(summer.toString());
		// 枚举类默认继承于 java.lang.Enum 类
		System.out.println("enum Season1 父类：" + Season1.class.getSuperclass());
		System.out.println("********************************");

		// values()：返回所有的枚举类对象构成的数组
		Season1[] values = Season1.values();
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
			values[i].show();
		}
		System.out.println("********************************");

		Thread.State[] values1 = Thread.State.values();
		for (int i = 0; i < values1.length; i++) {
			System.out.println(values1[i]);
		}

		// valueOf(String objName)：返回枚举类中对象名是 objName 的对象。
		Season1 winter = Season1.valueOf("WINTER");
		System.out.println(winter);
		winter.show();

		// 如果没有 objName 的枚举类对象，则抛异常：IllegalArgumentException
//		Season1 winter1 = Season1.valueOf("WINTER1");
	}
}

/**
 * 方式一：自定义枚举类
 */
class Season {
	// 1.声明 Season 对象的属性：private final 修饰
	private final String seasonName;
	private final String seasonDesc;

	// 2.私有化类的构造器，并给对象属性赋值
	private Season(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	// 3.提供当前枚举类的多个对象：public static final
	public static final Season SPRING = new Season("春天", "春暖花开");
	public static final Season SUMMER = new Season("夏天", "夏日炎炎");
	public static final Season AUTUMN = new Season("秋天", "秋高气爽");
	public static final Season WINTER = new Season("冬天", "冰天雪地");

	// 4.其他诉求 1：获取枚举类对象的属性
	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}

	// 4.其他诉求 2：提供toString()
	@Override
	public String toString() {
		return "Season{" +
				"seasonName='" + seasonName + '\'' +
				", seasonDesc='" + seasonDesc + '\'' +
				'}';
	}
}

interface Info {
	void show();
}

/**
 * 方式二：使用 enum 关键字定义枚举类
 * 说明：定义的枚举类默认继承于 java.lang.Enum 类
 */
enum Season1 implements Info {
	// 1.提供当前枚举类的对象，多个对象之间用 "," 隔开，末尾对象 ";" 结束
	SPRING("春天", "春暖花开") {
		@Override
		public void show() {
			System.out.println("春天来了！");
		}
	},
	SUMMER("夏天", "夏日炎炎") {
		@Override
		public void show() {
			System.out.println("夏天好热！");
		}
	},
	AUTUMN("秋天", "秋高气爽") {
		@Override
		public void show() {
			System.out.println("秋天好爽！");
		}
	},
	WINTER("冬天", "冰天雪地") {
		@Override
		public void show() {
			System.out.println("冬天太冷！");
		}
	};

	// 2.声明Season对象的属性：private final修饰
	private final String seasonName;
	private final String seasonDesc;

	// 2.私有化类的构造器，并给对象属性赋值
	private Season1(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	// 4.其他诉求1：获取枚举类对象的属性
	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}
}
