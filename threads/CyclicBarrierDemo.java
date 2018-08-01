import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // CyclicBarrier 相当于一个屏障，并且是可重用的，先抵达屏障的线程会阻塞，直到所有线程都抵达屏障，再继续执行
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.printf("线程 %s 抵达屏障\n", Thread.currentThread().getName());
                    cyclicBarrier.await();
                    System.out.printf("线程 %s 抵达第二道屏障\n", Thread.currentThread().getName());
                    // 屏障可重用，这里再次设置屏障
                    cyclicBarrier.await();
                    System.out.println("所有线程继续执行...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
