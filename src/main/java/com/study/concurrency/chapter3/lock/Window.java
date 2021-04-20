package com.study.concurrency.chapter3.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Window implements Runnable{
    private ReentrantLock lock = new ReentrantLock(true);
    private Integer ticket = 10000;
    @Override
    public void run() {


        lock.lock();
        while (ticket > 0){
            ticket -= 1;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s,%d", Thread.currentThread().getName(), ticket ));

        }
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        Window window = new Window();
        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);

        thread1.setName("1");
        thread2.setName("2");
        thread3.setName("3");


        thread2.start();
        thread3.start();
        thread1.start();


        thread3.join();
        thread1.join();
        thread2.join();

    }
}
