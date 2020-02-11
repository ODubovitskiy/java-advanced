package Synchronized_1;

public class Main {

    int counter;

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main();
        main.run();

    }

    private synchronized void incr(){
        counter++;
    }

    private void run() throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    incr();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    incr();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}
