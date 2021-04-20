package com.study.concurrency.chapter3.communicate;

public class Window implements Runnable {
    private Integer ticket = 100;
    @Override
    public synchronized void  run() {

        while (ticket > 0){
            notify();
            ticket -= 1;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s,%d", Thread.currentThread().getName(), ticket));
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s-finish",Thread.currentThread().getName()));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Window window = new Window();
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);


        thread1.start();
        thread2.start();
//        thread3.start();


        thread1.join();
        thread2.join();
//        thread3.join();
    }
}
