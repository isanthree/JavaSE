package com.isanthree.interface_;

public class SuperClass {
    // 和 UserService 同名同属性方法
    public void sameMethod() {
        System.out.println("（父类同名同属性方法）SuperClass :: sameMethod()");
    }

    // 和多个接口同名同属性方法
    public void interfaceSameMethod() {
        System.out.println("（父类同名同属性方法）SuperClass :: interfaceSameMethod()");
    }
}
