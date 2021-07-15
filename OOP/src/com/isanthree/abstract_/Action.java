package com.isanthree.abstract_;

/**
 * 抽象类：abstract，抽象的抽象，没有实现，仅仅约束一个方法，让别人来帮忙实现
 * 1.抽象类是不能 new（实例化） 的，只能去实例化其子类
 * 2.抽象类中一定有构造器，便于子类实例化时调用（涉及：子类对象实例化的全过程）
 * 3.抽象方法必须存在于抽象类，但是，抽象类里面也可以存在普通方法（没有 abstract 修饰）
 */
public abstract class Action {

    public Action() {}

    // abstract：抽象方法，只有方法名，没有方法的实现
    public abstract void doSomething();
}

/*
 * abstract 使用上的注意点：
 * 1.不能修饰属性、构造器等结构
 * 2.不能修饰私有方法、静态方法、final 修饰的方法或类
 */
