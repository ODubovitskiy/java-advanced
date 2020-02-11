package Threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Work(i));
        }

        executorService.shutdown();
        System.out.println("All tasks have been assigned");
        executorService.awaitTermination(1, TimeUnit.DAYS);

    }

    static class Work implements Runnable {
        private int id;

        public Work(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Work " + id + " has been fulfilled");

        }
    }

}
