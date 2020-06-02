package com.demo.study.patterns.factory;

import java.util.ArrayList;
import java.util.List;

interface Factory {
    boolean support(String operateName);

    void operation();
}

class ListFactory implements Factory {

    @Override
    public boolean support(String operateName) {
        return "LIST".equalsIgnoreCase(operateName);
    }

    @Override
    public void operation() {
        System.out.println("查询操作");
    }
}

class AddFactory implements Factory {
    @Override
    public boolean support(String operateName) {
        return "ADD".equalsIgnoreCase(operateName);
    }

    @Override
    public void operation() {
        System.out.println("新增操作");
    }
}

class UpdateFactory implements Factory {
    @Override
    public boolean support(String operateName) {
        return "UPDATE".equalsIgnoreCase(operateName);
    }

    @Override
    public void operation() {
        System.out.println("修改操作");
    }
}

class DelFactory implements Factory {
    @Override
    public boolean support(String operateName) {
        return "DELETE".equalsIgnoreCase(operateName);
    }

    @Override
    public void operation() {
        System.out.println("删除操作");
    }
}

public class FactorySimple {

    private static List<Factory> list = new ArrayList<>();

    public static void main(String[] args) {
        list.add(new AddFactory());
        list.add(new ListFactory());
        list.add(new UpdateFactory());

        String operationName = "add";
        Factory factory = list.stream()
                .filter(c -> c.support(operationName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("no operation resolver matches!"));
        factory.operation();
//        Factory factory = new DelFactory();
//        factory.operation();
    }


}

