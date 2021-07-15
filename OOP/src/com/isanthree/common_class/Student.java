package com.isanthree.common_class;

/**
 * 派生类或子类
 */
public class Student extends Person {

    private static int age;  // 静态变量 多线程
    private double score;  // 非静态变量

    public static String staticStr;  // 用于 static 修饰的属性测试

    // 非静态方法
    public void testNonStatic() {
        System.out.println("(son) Student :: testNonStatic()");
    }

    // 静态方法
    public static void testStatic() {
        System.out.println("(son) Student :: testStatic()");
    }

    @Override
    public void run() {
        System.out.println("(son) Student :: run()");
    }

    public void eat() {
        System.out.println("(son) Student :: eat()");
    }
}
