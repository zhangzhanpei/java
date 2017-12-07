package threads;

import java.util.concurrent.CountDownLatch;

//实现Runnable接口
public class Increment implements Runnable {
    private Global g; //全局变量
    private CountDownLatch l; //线程计数器

    public Increment(Global globalData, CountDownLatch latch) {
        g = globalData;
        l = latch;
    }

    //这里需要使用 synchronized 关键字修饰，即这个方法是同步的，线程安全的，互斥的。多个线程只能有一个线程执行这个run方法
    public synchronized void run() {
        for (int i = 0; i < 100000; i++) {
            g.sum++;
        }
        l.countDown(); //计数器减一
    }
}
