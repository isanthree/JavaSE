package com.isanthree.thread.synchronization;

/**
 * 使用同步方法解决实现 Runnable 接口的线程安全问题
 */
class Window3_ implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (ticket > 1) {
            show();
        }
    }

    private synchronized void show(){  // 同步监视器：this
        //synchronized (this){
            if (ticket > 0) {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);

                ticket--;
            }
        //}
    }
}


public class WindowTest3 {
    public static void main(String[] args) {
        Window3_ w = new Window3_();

        Thread thread1 = new Thread(w);
        Thread thread2 = new Thread(w);
        Thread thread3 = new Thread(w);

        thread1.setName("窗口 1 ");
        thread2.setName("窗口 2 ");
        thread3.setName("窗口 3 ");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
