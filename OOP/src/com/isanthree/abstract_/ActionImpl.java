package com.isanthree.abstract_;

/**
 * 继承抽象类的子类：所有方法必须要重写，除非子类也是抽象类
 */
public class ActionImpl extends Action {
    @Override
    public void doSomething() {
        System.out.println("抽象类子类的重写方法！");
    }
}
