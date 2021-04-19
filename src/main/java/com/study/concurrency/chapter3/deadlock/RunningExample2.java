package com.study.concurrency.chapter3.deadlock;

public class RunningExample2 {
    public static void main(String[] args) {
        try {
            Thread waitThread = new HelperClass2.WaitingThread();
            Thread wakingThread = new HelperClass2.WakingThread();

            //Start the execution.
            waitThread.start();
            wakingThread.start();

            //Wait for all threads to terminate.
            waitThread.join();
            wakingThread.join();
        }
        catch (InterruptedException ex) {
            System.err.println("An InterruptedException was caught: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
