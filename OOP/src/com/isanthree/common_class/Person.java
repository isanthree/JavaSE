package com.isanthree.common_class;

/**
 * 父类
 */
public class Person {

    // 匿名代码块也可以用来赋一些初始值
    {
        System.out.println("Person :: 匿名代码块");
    }

    // 静态代码块只执行一次
    static {
        System.out.println("Person :: 静态代码块");
    }

    public Person() {
        System.out.println("Person :: 无参构造方法");
    }

    public void testNonStatic() {
        System.out.println("(father) Person :: testNonStatic()");
    }

    public static void testStatic() {
        System.out.println("(father) Person :: testStatic()");
    }

    public void run() {
        System.out.println("(father) Person :: run()");
    }
}
