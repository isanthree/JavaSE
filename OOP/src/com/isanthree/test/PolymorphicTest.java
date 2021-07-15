package com.isanthree.test;

import com.isanthree.common_class.Person;
import com.isanthree.common_class.Student;
import org.junit.Test;

/**
 * 多态：一个方法可以根据发送对象的不同而采用多种不同的行为方式。
 *      父类的引用指向子类的对象（或子类的对象赋给父类引用）：一个对象的实际类型（等号右边）是确定的，但是，可以指向的引用类型（等号左边）是不确定的
 * 1. 多态是方法的多态，属性没有多态
 * 2. 存在条件：继承关系，方法需要重写，父类的引用指向子类对象：Father father = new Son();
 *  1）static 方法：属于类，不属于实例，不能被重写
 *  2）non-static 方法：可以被重写
 *  3）final 常量：不能被重写
 */
public class PolymorphicTest {

    @Test
    public void test() {
        /*
         * 一个对象的实际类型（等号右边）是确定的，但是，
         * 可以指向的引用类型（等号左边）是不确定的：父类的引用指向子类
         */
        Student student = new Student();
        Person person = new Student();
        Object object = new Student();

        /*
         * 对象能执行哪些方法，主要看对象左边的类型，和右边关系不大
         * student 能调用的方法都是自己的或者继承自父类的
         * person 能调用的方法都是自己的，而不能调用子类独有的方法
         */
        student.run();
        person.run();
//        person.eat();  // error
        ((Student)person).eat();  // 强转
        ((Student)object).eat();  // 强转
        ((Student)object).run();  // 强转
    }

// ========================= 分割线 =========================

    /**
     * 这个测试解释了为什么需要有「多态性」存在
     * func 方法的形参使父类 Animal，可以传入其子类
     * 对于方法，编译看左边，运行看右边
     */
    @Test
    public void test1() {
        func(new Dog());  // 输出：狗类的动作
        func(new Cat());  // 输出：猫类的动作
    }

    public static void func(Animal animal){
        animal.action();
    }

    /**
     * 这个测试是为了说明：多态只适用于方法，而不适用于属性。
     * 对于属性，编译、运行都看左边
     */
    @Test
    public void test2() {
        Animal dog = new Dog();
        Animal cat = new Cat();
        System.out.println(dog.className);  // 输出：Animal Class
        System.out.println(cat.className);  // 输出：Animal Class
    }
}

class Animal{
    String className = "Animal Class";

    // 在多态情况下，该方法为虚拟方法
    public void action(){}
}

class Dog extends Animal{
    String className = "Dog Class";

    @Override
    public void action() {
        System.out.println("狗类的动作");
    }
}

class Cat extends Animal{
    String className = "Cat Class";

    @Override
    public void action() {
        System.out.println("猫类的动作");
    }
}

/*
 * Java 引用变量有两个类型： 编译时类型 和 运行时类型
 *  - 编译时类型由声明该变量时使用的类型决定；
 *  - 运行时类型由实际赋给该变量的对象决定；
 *  - 简称： 编译时，看左边；运行时，看右边。
 *  若编译时类型和运行时类型不一致，就出现了对象的多态性 (Polymorphism)
 *  多态情况下："看左边" 看的是父类的引用，父类中不具备子类特有的方法
 *              "看右边" 看的是子类的对象，实际运行的是子类重写父类的方法
 */

/*
 * 1.为什么要有多态性？
 * 可以避免代码的冗余，避免将参数写死而导致代码的难以复用。
 * 如果没有多态，那么抽象类和接口也就没有意义，体现不了java 的面向对象编程思想。
 * PS：多态只适用于方法，而不适用于属性。
 *
 * 2.多态是编译时行为还是运行时行为？
 * 答：运行时行为。子类中定义了与父类同名同参数的方法，在多态情况下，将此时父类的方法称为虚拟方法，
 * 父类根据赋给它的不同子类对象，动态调用属于子类的该方法。这样的方法调用在编译期是无法确定的。
 * 证明：test1() 方法。
 */
