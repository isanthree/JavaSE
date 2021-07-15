package com.isanthree.test;

import com.isanthree.common_class.Person;
import com.isanthree.common_class.Student;
import org.junit.Test;

/**
 * 继承：同名的「静态」和「非静态」方法测试
 */
public class InheritTest {

    /**
     * 测试「非静态的」父类、子类同名方法
     * 测试结果为：重写了父类的同名方法
     */
    @Test
    public void testNonStatic() {
        Student student = new Student();
        Person person = new Student();  // 这里父类的引用指向了子类；方法的调用纸盒左边定义的数据类型有关

        person.testNonStatic();  // 输出：Student :: testNonStatic()
        student.testNonStatic();  // 输出：Student :: testNonStatic()
    }

    /**
     * 测试「静态的」父类、子类同名方法
     */
    @Test
    public void testStatic() {
        Student student = new Student();
        Person person = new Student();  // 这里父类的引用指向了子类；方法的调用纸盒左边定义的数据类型有关

        person.testStatic();  // 输出：Person :: testStatic()
        student.testStatic();  // 输出：Student :: testStatic()
    }
}
