package com.study.concurrency.chapter3.deadlock;
import java.util.concurrent.TimeUnit;

public class HelperClass2 {
    //The Object used for synchronization among threads.
    public final static Object obj1 = new Object();
    public final static Object obj2 = new Object();

    public static class WaitingThread extends Thread {

        @Override
        public void run() {
            synchronized (obj1) {
                try {
                    obj2.notify();
                    System.out.println("[WaitingThread]: Waiting for another thread "
                            + "to notify me...");
                    obj1.wait();
                    System.out.println("[WaitingThread]: Successfully notified!");

                }
                catch (InterruptedException ex) {
                    System.err.println("[WaitingThread]: An InterruptedException was caught: "
                            + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
    }

    public static class WakingThread extends Thread {
        @Override
        public void run() {
            synchronized (obj2) {
                try {
                    obj2.wait();
                    System.out.println("[WakingThread]: Sleeping for some time...");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("[WakingThread]: Woke up!");

                    System.out.println("[WakingThread]: About to notify another thread...");
                    obj2.notify();
                    System.out.println("[WakingThread]: Successfully notified some other thread!");
                }
                catch (InterruptedException ex) {
                    System.err.println("[WaitingThread]: An InterruptedException was caught: "
                            + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
    }
}
