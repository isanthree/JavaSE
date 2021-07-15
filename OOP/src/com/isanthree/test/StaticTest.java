package com.isanthree.test;

import com.isanthree.common_class.Person;
import com.isanthree.common_class.Student;
import org.junit.Test;

/**
 * static：静态变量或方法对于类、所有对象（实例）是共同享有的，当能够直接使用类去调用，说明这个变量或方法是静态的
 *      静态变量或方法是和类一起加载的
 */
public class StaticTest {

    @Test
    public void test() {
        Student.testStatic();  // 直接使用类去调用
        new Student().testNonStatic();  // 实例化一个对象去调用
    }

    /*
     * 实例化一个对象时的执行顺序：静态代码块 > 匿名代码块 > 构造方法
     * 且静态代码块只执行一次，匿名代码块可以用来赋一些初始值
     */
    @Test
    public void testCodeBlock() {
        Person person = new Person();
        System.out.println("=====================");
        Person person1 = new Person();
    }

    /**
     * 测试 static 修饰的属性是所有对象所共有的，其值可以被所有对象修改
     */
    @Test
    public void testStaticVar() {
        Student studentA = new Student();
        Student studentB = new Student();

        studentA.staticStr = "123";
        System.out.println(studentA.staticStr);

        studentB.staticStr = "456";
        System.out.println(studentA.staticStr);
    }
}

/*
 * static 注意点：
 *  1.在静态的方法内，不能使用 this 关键字、super 关键字
 *  2.关于静态属性和静态方法的使用，大家都从生命周期的角度去理解。
 *
 * 开发中，如何确定一个属性是否要声明为 static 的？
 *  - 属性是可以被多个对象所共享的，不会随着对象的不同而不同的。
 *  - 类中的常量也常常声明为 static
 *
 * 开发中，如何确定一个方法是否要声明为 static 的？
 *  - 操作静态属性的方法，通常设置为 static 的
 *  - 工具类中的方法，习惯上声明为 static 的。 比如：Math、Arrays、Collections
 */
