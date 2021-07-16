package com.isanthree.thread.creation;

/**
 * 多线程的创建
 * 方式二：实现 Runnable 接口
 * 1.创建一个实现类 Runnable 接口的类
 * 2.实现类去实现 Runnable 中的抽象方法 --> 将此线程执行的操作实现在 run() 中
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到 Thread 类的构造器中，创建 Thread 类的对象
 * 5.通过 Thread 类的对象调用 start()
 */
// 1.创建一个实现类 Runnable 接口的类
class MThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
    }
}

public class ThreadCreation2ImplementsRunnable {
    public static void main(String[] args) {
        // 3.创建实现类的对象
        MThread mThread = new MThread();
        // 4.将此对象作为参数传递到 Thread 类的构造器中，创建 Thread 类的对象
        Thread t1 = new Thread(mThread);
        // 5.通过 Thread 类的对象调用 start()：1️⃣启动线程 2️⃣调用当前线程的 run()
        t1.start();

        // 再启动一个线程，遍历 100 以内的数
        Thread t2 = new Thread(mThread);
        t2.start();

    }
}
