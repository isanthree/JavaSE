package com.isanthree.common_classes.string;

/**
 * 一道面试题
 */
public class StringTest {

    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'b';
        System.out.println("str: " + str);
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);  // 这里 String 类型参数的传递是地址的传递，不影响真实值
        System.out.println(ex.str);  // good
        System.out.println(ex.ch);  // best
    }
}
