package com.isanthree.thread.synchronization;

/**
 * 例子：创建三个窗口卖票，总票数为 100 张.使用实现 Runnable 接口的方式
 *
 * 解决同步问题：
 *   方式一：同步代码块
 *
 *    synchronized(同步监视器){
 *       //需要被同步的代码
 *    }
 *
 * PS：在继承 Thread 类创建多线程的方式中，慎用 this 充当同步监视器，考虑使用当前类充当同步监视器。
 */
class Window2_ extends Thread {

    private static int ticket = 100;

    private static final Object obj = new Object();  // 可以注释掉 final

    @Override
    public void run() {

        while(true) {
//            synchronized (this) {  // 错误的：this 代表着 t1, t2, t3 三个对象
//            synchronized (obj) {  // 正确的，obj 是 static 修饰的
            synchronized (Window2_.class) {  // Class clazz = Window2_.class; Window2_.class 只会加载一次
                if(ticket > 0){

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2_ t1 = new Window2_();
        Window2_ t2 = new Window2_();
        Window2_ t3 = new Window2_();

        t1.setName("窗口 1 ");
        t2.setName("窗口 2 ");
        t3.setName("窗口 3 ");

        t1.start();
        t2.start();
        t3.start();
    }
}
