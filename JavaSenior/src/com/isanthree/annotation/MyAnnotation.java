package com.isanthree.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Inherited
@Repeatable(MyAnnotations.class)  // 可重复的注解
@Retention(RetentionPolicy.RUNTIME)  // 只有声明为 RUNTIME 生命周期的注解，才能通过反射获取
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
public @interface MyAnnotation {

	String value() default "hello";
}
