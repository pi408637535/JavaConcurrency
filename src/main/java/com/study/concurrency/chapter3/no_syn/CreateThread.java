package com.study.concurrency.chapter3.no_syn;

public class CreateThread {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.start();
        window2.start();
        window3.start();

        try {
            window1.join();
            window2.join();
            window3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
