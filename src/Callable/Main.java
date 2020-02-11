package Callable;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(() -> {
            Random random = new Random();
            int value = random.nextInt(10);
            if (value > 5) {
                throw new Exception("Oops...");
            }
            return value;
        });
        executorService.shutdown();
        try {
            int  result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
