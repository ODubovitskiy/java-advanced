package test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new MyClass().work();
    }

    static class MyClass {
        private volatile List<Integer> list1 = new ArrayList<>();

        private synchronized void addToList1(int i) {
            list1.add(i);
        }

        public void work() throws InterruptedException {
                run();
        }

        public void run() throws InterruptedException {
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        addToList1(i);
                    }
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        addToList1(i);
                    }
                }
            });

            thread1.start();
            thread2.start();

            System.out.println(list1.size());
        }
    }
}

