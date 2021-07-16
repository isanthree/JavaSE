package com.isanthree.thread.creation;

/**
 * 测试 Thread 中的常用方法：
 * 1. start()：启动当前线程；调用当前线程的 run()
 * 2. run()：通常需要重写 Thread 类中的此方法，将创建的线程要执行的操作实现在此方法中
 * 3. currentThread()：静态方法，返回执行当前代码的线程
 * 4. getName()：获取当前线程的名字
 * 5. setName()：设置当前线程的名字，也可带参构造初始化线程名字
 * 6. yield()：释放当前cpu的执行权
 *  - 【PS 当前线程：我放弃了，但是我不把 CPU 给你，我们再次公平竞争】
 * 7. join()：在线程 a 中调用线程 b 的 join()，此时线程 a 就进入阻塞状态，直到线程 b 完全执行完以后，线程 a 才结束阻塞状态。
 *  - 【PS 当前线程：我放弃了，然后你上，等你做完了，我再上】
 * 8. stop()：已过时。当执行此方法时，强制结束当前线程。
 * 9. sleep(long millitime)：让当前线程“睡眠”指定的 millitime 毫秒。在指定的 millitime 毫秒时间内，当前
 *                           线程是阻塞状态。
 * 10. isAlive()：判断当前线程是否存活
 *
 *
 * 线程的优先级：
 * 1.MAX_PRIORITY：10
 *   MIN _PRIORITY：1
 *   NORM_PRIORITY：5（默认优先级）
 *
 * 2.如何获取和设置当前线程的优先级：
 *   getPriority():获取线程的优先级
 *   setPriority(int p):设置线程的优先级
 *
 * PS：高优先级的线程要抢占低优先级线程 cpu 的执行权。但是只是从概率上讲，高优先级的线程高概率被执行，
 * 但是，并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行。
 */
class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            try {
//                sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            System.out.println(Thread.currentThread().getName() + "：" +
                    "优先级：" + Thread.currentThread().getPriority() +
                    "，i = " + i);

//            if(i % 10 == 0){
//                yield();  // 当前线程释放 CPU 资源
//            }
        }
    }

    // 带参构造初始化线程名字
    public HelloThread(String name) {
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {

        HelloThread h1 = new HelloThread("分线程-1");

//        h1.setName("分线程-1 ");

        h1.setPriority(Thread.MAX_PRIORITY);  // 设置分线程的优先级

        h1.start();

        // 给主线程命名
        Thread.currentThread().setName("主线程-0");

        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);  // 设置分线程的优先级

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "：" +
                    "优先级：" + Thread.currentThread().getPriority() +
                    "，i = " + i);

            if(i == 10) {
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(h1.isAlive());  // h1 线程是否还存活
    }
}
