package com.isanthree.interface_;

public interface TimeService {
    void timer();

    // 和接口 UserService 同名同属性方法
    default void interfaceSameMethod() {
        System.out.println("（接口同名同属性方法）TimeService :: interfaceSameMethod()");
    }
}
