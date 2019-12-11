/**
 * 两个线程交替运行，打印奇偶数
 */
class Solution {
    public static void main(String[] args) {
        Object obj = new Object();

        // a 线程打印偶数
        new Thread(() -> {
            synchronized (obj) {
                try {
                    for (int i = 0; i < 10; i = i + 2) {
                        System.out.println(Thread.currentThread().getName() + "打印：" + i);
                        obj.notify(); // 唤醒另一个线程
                        obj.wait(); // 当前线程释放锁并等待
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "a").start();

        // b 线程打印奇数
        new Thread(() -> {
            synchronized (obj) {
                try {
                    for (int i = 1; i < 10; i = i + 2) {
                        System.out.println(Thread.currentThread().getName() + "打印：" + i);
                        obj.notify(); // 唤醒另一个线程
                        obj.wait(); // 当前线程释放锁并等待
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "b").start();
    }
}
