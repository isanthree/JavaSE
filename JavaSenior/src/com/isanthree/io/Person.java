package com.isanthree.io;

import java.io.Serializable;

/**
 * Person 需要满足如下的要求，方可序列化
 * 1.需要实现接口：Serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3.除了当前 Person 类需要实现 Serializable 接口之外，还必须保证其内部所有属性
 *  也必须是可序列化的。（默认情况下，基本数据类型可序列化）
 *
 *
 * 补充：ObjectOutputStream 和 ObjectInputStream 不能序列化 static 和 transient 修饰的成员变量
 */
public class Person implements Serializable {

	public static final long serialVersionUID = 475463534532L;

	private String name;
	private int age;
	private int id;
	private Account acct;

	public Person(String name, int age, int id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}

	public Person(String name, int age, int id, Account acct) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.acct = acct;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", id=" + id +
				", acct=" + acct +
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

	public Person() {

	}
}

class Account implements Serializable {
	public static final long serialVersionUID = 4754534532L;
	private double balance;

	@Override
	public String toString() {
		return "Account{" +
				"balance=" + balance +
				'}';
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account(double balance) {

		this.balance = balance;
	}
}