package com.isanthree.thread.synchronization;

/**
 * 使用同步方法处理继承 Thread 类的方式中的线程安全问题
 */
class Window4_ extends Thread {


    private static int ticket = 100;

    @Override
    public void run() {

        while (Window4_.ticket > 0) {

            show();
        }

    }
    private static synchronized void show(){//同步监视器：Window4.class
        //private synchronized void show(){ //同步监视器：t1,t2,t3。此种解决方式是错误的
        if (ticket > 0) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
            ticket--;
        }
    }
}


public class WindowTest4 {
    public static void main(String[] args) {
        Window4_ t1 = new Window4_();
        Window4_ t2 = new Window4_();
        Window4_ t3 = new Window4_();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}