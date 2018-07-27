import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // Semaphore 信号量，用于控制同时访问的线程数，通过维护一组许可证来实现
        final Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 10; i++) {
            int k = i;
            new Thread(() -> {
                try {
                    // semaphore 维护了 2 个许可证，这里取走一个（如果所有许可证都用光了，则阻塞）
                    semaphore.acquire();
                    System.out.printf("第 %d 位顾客购物中\n", k);
                    Thread.sleep(1000);
                    // 这里线程工作完毕后，给 semaphore 新增一个许可证，让下一个线程可以进来
                    semaphore.release();
                    System.out.printf("第 %d 位顾客购物完毕离开...\n", k);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
