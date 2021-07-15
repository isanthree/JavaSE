package com.isanthree.interface_;

import org.junit.Test;

/**
 * 实现 UserService 接口的类：
 * 1. 需要重写接口的方法
 * 2. 可以实现多个接口 —— 多继承（因此，虽然在 Java 中类是单继承的，但是可以利用接口实现多继承）
 *
 * 该类还继承与父类 SuperClass：
 *  - 用于测试「当子类调用父类和接口的同名同属性方法时，程序的执行」
 */
public class UserServiceImpl extends SuperClass implements UserService, TimeService {
    @Override
    public void interfaceSameMethod() {
        System.out.println("（子类）UserServiceImpl :: interfaceSameMethod() : 子类重写的多个接口定义的同名同属性方法");
    }

    /**
     * 在子类中测试父类和接口被子类重写的同名同属性方法
     */
    @Test
    public void test1() {
        interfaceSameMethod();  // 调用子类自己重写的方法
        super.interfaceSameMethod();  // 调用父类中的方法

        // 调用接口中的默认方法
        UserService.super.interfaceSameMethod();
        TimeService.super.interfaceSameMethod();
    }

    @Override
    public void add(String name) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public void update(String name) {

    }

    @Override
    public void query(String name) {

    }

    @Override
    public void timer() {

    }
}
