package com.isanthree.interface_;

import javax.sound.midi.Soundbank;

/**
 * 普通类：只有具体实现
 * 抽象类：具体方法和规范（抽象方法）都有
 *
 * 接口：只有规范，自己无法写方法，仅仅是专业的约束，
 *      接口都需要有实现类；
 *      约束和实现分离：面向接口编程
 *      接口不能被实例化，并且没有构造方法
 * 接口本质：是契约、标准、规范，类似于法律，指定好后大家得遵循
 *
 * 小结：
 * 1. 约束
 * 2. 定义一些方法，让不同的人去实现
 * 3. public abstract，抽象方法
 * 4. public static final，常量
 * 5. 接口不能被实例化，并且没有构造方法
 * 6. implements 可以实现多个接口
 * 7. 必须重写接口中的方法
 * 8. 主要用途：被实现类实现（面向接口编程）
 */
public interface UserService {
    // 接口中的所有属性都是静态常量：public static final，不需要显式写出来。
    // 但是，一般不在接口中定义常量
    int AGE = 99;

    // 接口中的所有定义其实都是抽象的：public abstract，不需要显式写出来
    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);

    // 静态方法
    static void staticMethod() {
        System.out.println("(接口静态方法) interface UserService :: staticMethod()");
    }

    // 默认方法
    default void defaultMethod() {
        System.out.println("(接口默认方法) interface UserService :: defaultMethod()");
    }

    // 和 SuperClass 同名同属性方法
    default void sameMethod() {
        System.out.println("（接口同名同属性方法）UserService :: sameMethod()");
    }

    // 和接口 TimeService 同名同属性方法
    default void interfaceSameMethod() {
        System.out.println("（接口同名同属性方法）UserService :: sameMethod()");
    }
}

/*
 * 接口的使用
 *
 * 1.接口使用 interface 来定义
 *
 * 2.Java 中，接口和类是并列的两个结构
 *
 * 3.如何定义接口：定义接口中的成员
 * 		3.1 JDK7 及以前：只能定义全局常量和抽象方法
 * 			- 全局常量：public static final 修饰，书写时，可以省略不写
 * 			- 抽象方法：public abstract 修饰
 * 		3.2 JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法（略）
 *
 * 4.接口中不能定义构造器的！意味着接口不可以实例化
 *
 * 5.Java 开发中，接口通过让类去实现（implements）的方式来使用.
 *   如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
 *   如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类
 *
 * 6.Java 类可以实现多个接口 --> 弥补了 Java 单继承性的局限性
 *   格式：class AA extends BB implements CC, DD, EE
 *
 * 7.接口与接口之间可以继承，而且可以多继承
 *
 * ***************************************************************************
 *
 * 8.接口的具体使用，体现多态性
 *
 * 9.接口，实际上可以看做是一种规范
 *
 * # 抽象类与接口有哪些异同？
 * 同：不能被实例化............待写
 *
 */
