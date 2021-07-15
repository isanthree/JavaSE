package com.isanthree.exercise;

public class DemoTest {
	public static void main(String[] args) {
		
		Boy boy = new Boy("罗密欧", 21);
		boy.shout();
		
		Girl girl = new Girl("朱丽叶", 18);
		girl.marry(boy);
		
		Girl girl1 = new Girl("祝英台",19);
		int compare = girl.compare(girl1);

		if(compare > 0){
			System.out.println(girl.getName() + "年龄大");
		}else if(compare < 0){
			System.out.println(girl1.getName() + "年龄大");
		}else{
			System.out.println("年龄相同");
		}
	}
}
