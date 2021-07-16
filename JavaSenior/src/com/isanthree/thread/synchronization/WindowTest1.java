package com.isanthree.thread.synchronization;

/**
 * 例子：创建三个窗口卖票，总票数为 100 张.使用实现 Runnable 接口的方式
 *
 * 解决同步问题：
 *  方式一：同步代码块
 *
 *   synchronized(同步监视器){
 *      //需要被同步的代码
 *   }
 *
 * PS：在实现 Runnable 接口创建多线程的方式中，我们可以考虑使用 this 充当同步监视器。
 */
class Window1_ implements Runnable {

    private int ticket = 100;
//    Object obj = new Object();
    Dog dog = new Dog();

    @Override
    public void run() {
//        Object obj = new Object();  // 这里定义则线程不安全，不是同一个对象（同步监视器）
        while(true){
            synchronized (this) {  // 此时的 this：唯一的 Window1 的对象
//            synchronized (dog) {  // 参数填写方式二
                if (ticket > 0) {

                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);

                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}


public class WindowTest1 {
    public static void main(String[] args) {
        Window1_ w = new Window1_();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口 1 ");
        t2.setName("窗口 2 ");
        t3.setName("窗口 3 ");

        t1.start();
        t2.start();
        t3.start();
    }
}


class Dog{

}
