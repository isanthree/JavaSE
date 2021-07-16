package com.isanthree.thread.synchronization;

/**
 * 例子：创建三个窗口卖票，总票数为 100 张.使用继承 Thread 类的方式
 *      存在线程的安全问题（重票等），待解决。
 */
class Window2 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while(true){

            if(ticket > 0){
                System.out.println(getName() + "：卖票，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }

        }
    }
}

public class WindowBase2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();


        t1.setName("窗口 1 ");
        t2.setName("窗口 2 ");
        t3.setName("窗口 3 ");

        t1.start();
        t2.start();
        t3.start();
    }
}
