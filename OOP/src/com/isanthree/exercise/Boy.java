package com.isanthree.exercise;

public class Boy {
	private String name;
	private int age;
	
	public Boy() {
		
	}
	
	public Boy(String name) {
		this.name = name;
	}

	public Boy(String name, int age) {
		this.name = name;
		this.age = age;
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
	
	public void marry(Girl girl){
		System.out.println(this.getName() + "：我想娶" + girl.getName());
	}
	
	public void shout(){
		if(this.age >= 20){
			System.out.println(this.getName() + "：你已到了合法登记结婚年龄！");
		}else{
			System.out.println(this.getName() + "：你还没到合法登记结婚年龄！");
		}
	}
}
