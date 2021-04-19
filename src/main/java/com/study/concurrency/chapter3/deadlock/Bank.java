package com.study.concurrency.chapter3.deadlock;

public class Bank {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();



    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()->{
            synchronized (lock1){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread1" + "lock1");
                synchronized (lock2){
                    System.out.println("thread1" + "lock2");
                }
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (lock2){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread2" + "lock1");
                synchronized (lock1){
                    System.out.println("thread2" + "lock2");
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
