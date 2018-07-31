import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAllDemo {
    public static void main(String[] args) {
        // 记录开始时间
        long a = System.currentTimeMillis();
        // 任务列表
        List<Callable<Long>> tasks = new ArrayList<>();
        // 加入任务
        tasks.add(() -> {
            long tmp = 0;
            for (int i = 0; i < 5; i++) {
                tmp += i;
                Thread.sleep(1000);
            }
            return tmp;
        });
        // 加入任务
        tasks.add(() -> {
            long tmp = 0;
            for (int i = 5; i < 10; i++) {
                tmp += i;
                Thread.sleep(1000);
            }
            return tmp;
        });
        // 创建固定数量的线程池，数量为 CPU 核心数
        ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            // 调用所有任务
            List<Future<Long>> results = exec.invokeAll(tasks);
            long sum = 0;
            // 取出每个线程的计算结果求和
            for (Future<Long> result : results) {
                sum += result.get();
            }
            System.out.println(sum);
        } catch (Exception e) {

        }
        // 关闭线程池
        exec.shutdown();
        // 计算多线程求和所花的时间
        long b = System.currentTimeMillis();
        // 两个线程都是 5 秒钟，所以总时间为 5 秒钟多一点点
        System.out.println(b - a);
    }
}
