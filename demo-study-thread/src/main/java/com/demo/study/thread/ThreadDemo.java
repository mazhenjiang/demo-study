package com.demo.study.thread;

/**
 * @description:
 * @author: Aaron Ma
 **/
public class ThreadDemo {
    public static void main(String[] args){
        bankSystemOne window1 = new bankSystemOne("一号");
        window1.start();

        bankSystemOne window2 = new bankSystemOne("二号");
        window2.start();

        bankSystemOne window3 = new bankSystemOne("三号");
        window3.start();

        bankSystemOne window4 = new bankSystemOne("四号");
        window4.start();
    }
}


class bankSystemOne extends Thread {
    private String name;
    private static final int max = 10;//最大号码到10
    private static int number = 1;// 当前叫到的号码

    public bankSystemOne(String name){
        this.name = name;
    }
    @Override
    public void run() {
        while(number <= max) {
            System.out.println(name + "窗口： " + number++);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

