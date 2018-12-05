import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    // 原子类型整数
    public static AtomicInteger n = new AtomicInteger(0);

    public static void main(String[] args) {
        // 5个线程，每个线程对n进行自增10000次
        CountDownLatch countDownLatch = new CountDownLatch(5);
        try {
            for (int i = 0; i < 5; i++) {
                new Thread(() -> {
                    for (int j = 0; j < 10000; j++) {
                        // 自增
                        n.getAndAdd(1);
                    }
                    countDownLatch.countDown();
                }).start();
            }
            // 等待5个线程结束
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 输出结果
        System.out.println(n);
    }
}
