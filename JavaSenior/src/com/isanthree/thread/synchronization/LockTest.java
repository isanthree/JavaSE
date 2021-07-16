package com.isanthree.thread.synchronization;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock 锁 —— JDK5.0 新增
 */
public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();

        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Window implements Runnable {

    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                // 2.调用 sock
                lock.lock();


                if (ticket > 0) {

                    try {  // 手动增加线程切换的概率
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：售票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                // 3.调用解锁方法
                lock.unlock();
            }
        }
    }
}