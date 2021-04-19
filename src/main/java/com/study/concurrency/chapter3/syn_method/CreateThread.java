package com.study.concurrency.chapter3.syn_method;

public class CreateThread {
    public static void main(String[] args) {
        WindowSyn window1 = new WindowSyn();
        WindowSyn window2 = new WindowSyn();
        WindowSyn window3 = new WindowSyn();

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
