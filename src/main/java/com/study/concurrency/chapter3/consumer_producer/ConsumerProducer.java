package com.study.concurrency.chapter3.consumer_producer;

import javafx.concurrent.Worker;

class Clerk{
    private Integer number = 10;

    public synchronized void consume(){
        while (true){
            if(number > 0){
                number -= 1;
                System.out.println(String.format("consume-%s-%d", Thread.currentThread().getName(), number));
                notify();
            }
            else{
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public synchronized void produce(){

        while(true){
            if(number > 10){
                notifyAll();
            }else {
                number += 1;
                System.out.println(String.format("produce-%s-%d", Thread.currentThread().getName(), number));

                notifyAll();
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}

class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        clerk.consume();
    }
}

class Producer implements Runnable{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        clerk.produce();
    }
}

public class ConsumerProducer {
    public static void main(String[] args) throws InterruptedException {
        Clerk clerk = new Clerk();
        Thread consumer1 = new Thread(new Consumer(clerk));
        Thread consumer2 = new Thread(new Consumer(clerk));

        Thread producer = new Thread(new Producer(clerk));

        consumer1.start();
        consumer2.start();
        producer.start();

        consumer1.join();
        consumer2.join();
        producer.join();


    }
}
