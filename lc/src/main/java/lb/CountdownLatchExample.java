package lb;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatchExample {
    static Random rnd = new Random();
    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 7;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                long id = Thread.currentThread().getId()%totalThread;
                try {
                    Thread.sleep(rnd.nextInt(1800));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run ok.."+id);
                countDownLatch.countDown();
                System.out.println("end.."+id);
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
