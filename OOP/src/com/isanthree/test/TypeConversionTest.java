package com.isanthree.test;

import com.isanthree.common_class.Person;
import com.isanthree.common_class.Student;

/**
 * 类型转换：父类（上级）转子类（下级）（需要强制转换），反之不需要
 *      子类转父类，可能丢失一些自己独有的方法
 *      方便方法的调动，减少重复的代码：简洁
 */
public class TypeConversionTest {

    Person obj1 = new Student();
    Student student = (Student)obj1;  // 强转

    Student obj2 = new Student();
    Person person = obj2;
}
