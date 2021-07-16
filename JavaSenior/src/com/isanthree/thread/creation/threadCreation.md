# 线程的创建（四种方式）

## Extends Thread

步骤：

1. 创建一个继承于 Thread 类的子类
2. 重写 Thread 类的 run() --> 将此线程执行的操作实现在 run() 中
3. 创建 Thread 类的子类的对象
4. 通过此对象调用 start()

## Implements Runnable

步骤：

1. 创建一个实现类 Runnable 接口的类
2. 实现类去实现 Runnable 中的抽象方法 --> 将此线程执行的操作实现在 run() 中
3. 创建实现类的对象
4. 将此对象作为参数传递到 Thread 类的构造器中，创建 Thread 类的对象
5. 通过 Thread 类的对象调用 start()

> 两种线程创建方式（继承 Thread 和 实现 Runnable 接口）的比较：
>
> - 选择：开发中，优先选择实现 Runnable 接口的方式，原因：（1）实现方式没有类的单继承局限性（2）实现方式更适合来处理多个线程有共享数据的情况；
>
> - 两者联系：public class Thread implements Runnable
>
> - 相同点：两种方式都需要重写 run() ，将线程要执行的逻辑声明在 run() 中

## Implements Callable

JDK5.0 新增的线程创建方式：实现 Callable 接口

与使用 Runnable 相比， Callable 功能更强大些：

- 相比 run() 方法，call() 可以有返回值
- call() 可以抛出异常，被外面的操作捕获，获取异常
- Callable 是支持泛型的，得到返回值

PS：该方式需要借助 FutureTask 类，比如获取返回结果

## ThreadPool

背景：经常创建和销毁、使用量特别大的资源，比如并发情况下的线程，对性能影响很大 。

思路： 提前创建好多个线程，放入线程池中，使用时直接 获取，使用完放回池中。可以 避免 频繁创建销毁、实现重复 利用。类似生活中的公共交
通工具。

好处：

1. 提高响应速度（减少了创建新线程的时间）
2. 降低资源消耗（重复利用线程池中线程，不需要每次都创建）
3. 便于线程管理
       corePoolSize：核心池的大小
       maximumPoolSize：最大线程数
       keepAliveTime：线程没有任务时最多保持多长时间后会终止



# 程序、进程、线程的理解



