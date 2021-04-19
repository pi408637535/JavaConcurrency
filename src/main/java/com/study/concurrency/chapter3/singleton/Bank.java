package com.study.concurrency.chapter3.singleton;

public class Bank {
    private String name;
    private Bank(String name) {

        this.name = name;
    }
    private static Bank  singleton;
//    public static synchronized Bank getSingleton(){
//        if(singleton == null)
//            singleton = new Bank("singleton");
//        return singleton;
//    }

    //改进
    public static Bank getSingleton(){
        if(singleton == null){
            synchronized (Bank.class){
                if(singleton == null){
                    singleton = new Bank("singleton");
                }
            }
        }
        return singleton;
    }
}
