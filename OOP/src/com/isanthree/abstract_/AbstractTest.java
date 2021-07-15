package com.isanthree.abstract_;

import org.junit.Test;

public class AbstractTest {
    /**
     * 创建抽象类的匿名子类：
     *  - 本来要创建的对象是子类 ActionImpl，但是写法上 new 的是父类，同时当场给出具体重写方法，实质上创建的就是子类
     *  - 创建的该子类是没有名字的
     */
    @Test
    public void test() {
        Action action = new Action() {
            @Override
            public void doSomething() {
                System.out.println("这里是抽象类的匿名子类的重写方法！");
            }
        };

        action.doSomething();
    }

    public void funcTest(Action action) {
        action.doSomething();
    }

    /**
     * 创建匿名子类的匿名对象
     */
    @Test
    public void test1() {
        funcTest(new Action(){
            @Override
            public void doSomething() {
                System.out.println("匿名子类的匿名对象");
            }
        });
    }
}
