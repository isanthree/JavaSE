package com.isanthree.bean;

/*
 * JavaBean 是一种 Java 语言写成的可重用组件。符合以下标准：
 *  - 类是公共的
 *  - 有一个无参的公共构造器
 *  - 有属性，且有对应的 get、set 方法
 */
public class Customer {
    private int id;
    private String name;

    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
