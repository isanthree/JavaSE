package com.isanthree.exception;

import org.junit.Test;

public class ExceptionTest {
    @Test
    public void tryTest() {
        int a = 1;
        int b = 0;

        // IDEA 快捷键：ctrl + Alt + T
        try {  // try 监控区域
            System.out.println(a / b);
        } catch (Throwable e) {  // 捕获异常
            System.out.println("程序出现异常：除数为 0");
            e.printStackTrace();
        } finally {  // 处理善后工作（可选）
            System.out.println("finally");
        }
    }

    public void throwFunc(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException();  // 主动抛出异常，一般在方法中使用
        }

        System.out.println(a / b);
    }

    @Test
    public void throwTest() {
        new ExceptionTest().throwFunc(1, 0);
    }

    // 可能会存在异常的方法
    static void myException(int a) throws MyException {
        System.out.println("传递的参数为：" + a);
        if (a > 10) {
            throw new MyException(a);
        }
        System.out.println("OK");
    }

    @Test
    public void myException() {
        try {
            myException(11);
        } catch (MyException e) {
            System.out.println("MyException => " + e);
//            e.printStackTrace();
        }
    }
}
