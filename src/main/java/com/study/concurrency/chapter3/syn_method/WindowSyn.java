package com.study.concurrency.chapter3.syn_method;

public class WindowSyn extends Thread{
    private static Integer ticker = 1000;
    private  static Object object = new Object();
    @Override
    public void  run() {
        show();
    }

    private static synchronized void show(){
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
