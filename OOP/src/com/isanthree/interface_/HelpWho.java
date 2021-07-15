package com.isanthree.interface_;

import org.junit.Test;

interface Filial {  // 孝顺的
	default void help() {
		System.out.println("我：老妈，我来救你了");
	}
}

interface Spoony {  // 痴情的
	default void help() {
		System.out.println("我：媳妇，别怕，我来了");
	}
}

class Father{
	public void help(){
		System.out.println("爸爸：儿子，救我媳妇！");
	}
}

public class HelpWho extends Father implements Filial, Spoony {
	// 继承了父类之后，就不需要自己选择救谁（重写）了，我可太难了
//	@Override
//	public void help() {
//		System.out.println("我该救谁呢？");
//		Filial.super.help();
//		Spoony.super.help();
//	}

	@Test
	public void helpWhoTest() {
		System.out.println("NPC: 你妈和你媳妇同时落水，你要救谁？");
		HelpWho helpWho = new HelpWho();
		helpWho.help();
	}
}
