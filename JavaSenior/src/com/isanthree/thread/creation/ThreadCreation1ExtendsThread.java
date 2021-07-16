package com.isanthree.thread.creation;

/**
 * 多线程的创建
 * 方式一：继承于 Thread 类
 * 1.创建一个继承于 Thread 类的子类
 * 2.重写 Thread 类的 run() --> 将此线程执行的操作实现在 run() 中
 * 3.创建 Thread 类的子类的对象
 * 4.通过此对象调用 start()
 */
// 1.创建一个继承于 Thread 类的子类
class MyThread extends Thread {
    /*
     * 例子：遍历 100 以内的所有数字
     */
    // 2.重写 Thread 类的 run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

public class ThreadCreation1ExtendsThread {

    public static void main(String[] args) {
        // 3.创建 Thread 类的子类的对象
        MyThread t1 = new MyThread();
        // 4.通过此对象调用 start()
        t1.start();  // start 方法：1.启动当前线程 2.自动地去调用当前线程的类 MyThread 里面的 run()

        // 如下操作仍在 main() 主线程中执行
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " --- main()：该线程打印可能先于 MyThread :: run() 线程的打印");
        }
    }
}
