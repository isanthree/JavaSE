package com.isanthree.thread.communication;

/**
 * 线程通信的例子：使用两个线程打印 1-100。线程 1，线程 2 交替打印
 */
class Number implements Runnable{
    private int number = 1;
    private Object obj = new Object();
    @Override
    public void run() {

        while(true){
            synchronized (obj) {
                obj.notify();

                if(number <= 100){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：" + number);
                    number++;

                    try {
                        // 使得调用如下 wait() 方法的线程进入阻塞状态
                        obj.wait();  // 当前线程暂停，并释放锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }
        }
    }
}

public class PrintNumberDemo {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程-1");
        t2.setName("线程-2");

        t1.start();
        t2.start();
    }
}