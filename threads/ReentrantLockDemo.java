import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static int count = 0;
    private static ReentrantLock reentrantLock = new ReentrantLock();

    /**
     * 同步方法
     */
    public static synchronized void incrCount()
    {
        count++;
    }

    /**
     * 可重入锁
     */
    public static void incrCount()
    {
        reentrantLock.lock();
        try {
            count++;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        // 两个线程进行 count++ 操作
        Runnable a = () -> {
            for (int i = 0; i < 100000; i++) {
                incrCount();
            }
        };

        Runnable b = () -> {
            for (int i = 0; i < 100000; i++) {
                incrCount();
            }
        };

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(a);
        exec.execute(b);

        try {
            Thread.sleep(1000);
            exec.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 打印结果
        System.out.println(count);
    }
}
