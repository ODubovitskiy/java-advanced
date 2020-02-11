package Synchronized_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {

            new Worker().run();
        }

    }

}

class Worker {

    List<String> list = new ArrayList<>();

    public void addString(String string) {


            list.add(string);


    }

    public void run() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread 1");
                int counter1 = 0;
                for (int i = 0; i < 1000; i++) {
                    addString(Thread.currentThread().getName());
                    counter1++;
                }
                System.out.println(counter1);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread 2");
                int counter2 = 0;
                for (int i = 0; i < 1000; i++) {
                    addString("===================================================");
                    counter2++;
                }
                System.out.println(counter2);

            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        System.out.println(list.size());

    }

}




