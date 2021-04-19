package com.study.concurrency.chapter3.deadlock;

public class IllegalMonitorStateWaitExample {
    public static void main(String[] args) {
        try {
            //Try to wait on the synchronization object, without owning it.
            //The following statement results in an IllegalMonitorStateException.
            HelperClass.obj.wait();
        }
        catch (InterruptedException ex) {
            System.err.println("An InterruptedException was caught: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
