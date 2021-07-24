package com.isanthree.reflection;

public class Person {

	private String name;
	public int age;
	public int id;

	private Person(String name) {
		this.name = name;
	}

	public Person() {
		System.out.println("Person()");
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person(String name, int age) {

		this.name = name;
		this.age = age;
	}

	public void show() {
		System.out.println("你好，我是一个人");
	}

	private String show(String nation) {
		System.out.println("我的国籍是：" + nation);
		return nation;
	}

	private static void showDesc() {
		System.out.println("我是一个中国人");
	}

	private String showNation(String nation) {
		System.out.println("我的国籍是：" + nation);
		return nation;
	}
}
