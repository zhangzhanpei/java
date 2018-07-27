import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        // CountDownLatch 相当于一个计数器，这里设置计数器的值为 3
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        System.out.println("6点了，小明需要等待其他员工下班后才能走...");

        // 小明在等待
        new Thread(() -> {
            try {
                // 子线程阻塞直到计数器的值减到 0
                countDownLatch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("小明终于下班了");
        }).start();

        // 其他员工陆续下班
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println("员工下班");
                    // 任务执行完毕后计数器减 1
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
