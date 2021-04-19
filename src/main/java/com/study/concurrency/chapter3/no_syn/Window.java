package com.study.concurrency.chapter3.no_syn;

public class Window extends Thread{
    private static Integer ticker = 100;
    @Override
    public void run() {

        while (ticker > 0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticker -= 1;
            System.out.println(Thread.currentThread().getName() + "==" + ticker);
        }
    }
}
