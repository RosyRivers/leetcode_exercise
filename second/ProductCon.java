import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductCon {

    // 使用线程池的方式实现生产者消费者问题
    public static void main(String[] args) throws InterruptedException {
        int nThreads = 8;
        ExecutorService productPool = Executors.newFixedThreadPool(nThreads);
        ExecutorService consumePool = Executors.newFixedThreadPool(nThreads);

        Runnable prod = () -> {
            for (int i = 0; i < 10000; i++) {
                System.out.printf("A");
            }
        };
        Runnable cons = () -> {
            for (int i = 0; i < 10000; i++) {
                System.out.printf("B");
            }
        };
        int count = 1;
        try (Scanner in = new Scanner(System.in)) {
            count = in.nextInt();
        }
        for (int i = 0; i < nThreads; i++) {
            productPool.submit(prod);
            consumePool.submit(cons);
        }

        Thread.sleep(5000);
        productPool.shutdown();
        consumePool.shutdown();

    }
}
