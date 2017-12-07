package threads;

import java.util.concurrent.CountDownLatch;

public class Index {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5); //声明一个计数器，即有5个线程
        Thread[] threads = new Thread[5];
        Increment incr = new Increment(latch);
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(incr); //创建线程
            threads[i].start(); //线程开始执行，会调用 Increment 的 run 方法
        }
        try {
            latch.await(); //等待所有线程执行完毕
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Global.sum); //打印最终结果
    }
}
