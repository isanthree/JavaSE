package com.isanthree.inner_class;

/**
 * 内部类的实例化，需要通过外部类来创建
 * 内部类可以访问外部类的私有属性和私有方法
 */
public class Outer {
    private int id;
    public void out() {
        System.out.println("外部类的方法 Outer :: out()");
    }

    /**
     * 成员内部类
     */
    public class MemberInner {
        public void in() {
            System.out.println("成员内部类的方法 Outer :: Inner :: in()");
        }

        // 获取外部类的私有属性
        public void outputID() {
            System.out.println("成员内部类的方法 Outer :: Inner :: outputID() : " + id);
        }
    }

    /**
     * 局部内部类
     */
    public void method() {
        class LocalInner {
            public void in() {

            }
        }
    }
}
