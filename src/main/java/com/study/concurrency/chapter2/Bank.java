package com.study.concurrency.chapter2;


class TicketWindow implements Runnable{


    private String name = "";

    public TicketWindow(String name) {
        this.name = name;
    }

    private static Integer num = 50;

    @Override
    public synchronized void  run() {

        while (true){
            notifyAll();
            System.out.println(this.name + "--" + num);
            num -= 1;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Thread ticketWindow1 = new Thread(new TicketWindow("counter1"));
        Thread ticketWindow2 = new Thread(new TicketWindow("counter2"));
        Thread ticketWindow3 = new Thread(new TicketWindow("counter3"));


        ticketWindow1.start();
        ticketWindow2.start();
        ticketWindow3.start();


        try {
            Thread.sleep(40*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
