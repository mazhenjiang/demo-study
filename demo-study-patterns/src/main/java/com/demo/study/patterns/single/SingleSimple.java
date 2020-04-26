package com.demo.study.patterns.single;

class Single {
    private static Single ourInstance = new Single();

    public static Single getInstance() {
        return ourInstance;
    }

    private String name;

    private Single() {
        this.name = "mark";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class SingleSimple{

    public static void main(String[] args) {
        Single instance = Single.getInstance();
        System.out.println(instance.getName());
        Single instance1 = Single.getInstance();
        System.out.println(instance.getName());
    }
}