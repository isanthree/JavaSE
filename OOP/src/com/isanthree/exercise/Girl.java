package com.isanthree.exercise;

public class Girl {
	
	private String name;
	private int age;
	
	public Girl() {

	}

	public Girl(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void marry(Boy boy){
		System.out.println(this.getName() + "：我想嫁给" + boy.getName());
		boy.marry(this);  // this：表示当前调用 marry 方法的对象
	}
	
	/**
	 * @Description 比较两个对象的年龄大小
	 * @param girl
	 * @return  正数：当前对象大；  负数：当前对象小  ； 0：当前对象与形参对象相等
	 */
	public int compare(Girl girl){
		return this.age - girl.age;
	}
}
