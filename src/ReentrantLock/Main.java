package ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(task.getCounter());
    }
}

class Task {
    private int counter = 0;
    private Lock lock = new ReentrantLock();

    public void firstThread() {
        lock.lock();
        increment();
        lock.unlock();
    }

    public void secondThread() {
            lock.lock();
            increment();
            lock.unlock();
    }

    private void increment() {
        for (int i = 0; i < 1000; i++) {
            counter++;
        }
    }

    public int getCounter() {
        return counter;
    }
}
