package com.isanthree.exception;

/**
 * 自定义异常类：可根据自己的需求进行定制
 */
public class MyException extends Exception {
    private int detail;
    public MyException(int a) {
        this.detail = a;
    }

    // 异常的打印信息
    @Override
    public String toString() {
        return "MyException{" +
                "detail=" + detail +
                '}';
    }
}
