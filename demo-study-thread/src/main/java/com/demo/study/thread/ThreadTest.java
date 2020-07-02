package com.demo.study.thread;

/**
 * @description:
 * @author: Aaron Ma
 **/
public class ThreadTest {

    public static void main(String[] args) {
//        MyThread threadDemo01 = new MyThread();
//        threadDemo01.setName("我是自定义的线程1");
//        threadDemo01.start();
//        System.out.println(Thread.currentThread().toString());

        new MyThreadRunable().run();


    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("myThread is running");
        System.out.println(Thread.currentThread().getName());
    }
}
class MyThreadRunable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}