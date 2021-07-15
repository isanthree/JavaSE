package com.isanthree.test;

import org.junit.Test;

/**
 * 单例设计模式：所谓 类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例
 * 优点：减少了系统性能开销
 *
 * 区分饿汉式和懒汉式：
 * 饿汉式：坏处，对象加载时间过长；好处：是线程安全的；
 * 懒汉式：坏处：目前这样的写法是线程不安全的；好处：延迟对象的创建；
 *
 */
public class SingletonDesignPatternTest {
    /**
     * 饿汉式实现测试
     */
    @Test
    public void testBankSingleton() {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1 == bank2);
    }

    /**
     * 懒汉式实现测试
     */
    @Test
    public void testOrderSingleton() {
        Order instance = Order.getInstance();
        Order instance1 = Order.getInstance();

        System.out.println(instance == instance1);
    }
}

/**
 * 饿汉式单例模式
 */
class Bank {
    // 1.私有化类的构造器
    private Bank() {

    }

    // 2.内部创建类的对象
    private static Bank instance = new Bank();

    // 3.提供公共的方法，返回类的对象
    public static Bank getInstance() {
        return instance;
    }
}

/**
 * 懒汉式单例模式
 */
class Order {
    // 1.私有化类的构造器
    private Order() {

    }

    // 2.声明当前类对象，并初始化为 null
    private static Order instance = null;

    // 3.提供公共的方法，返回类的对象
    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }
}
