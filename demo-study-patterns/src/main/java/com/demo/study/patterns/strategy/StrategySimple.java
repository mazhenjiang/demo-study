package com.demo.study.patterns.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 简单的策略模式
 * @author: Aaron Ma
 * 特性：
 * 使用同一个方法，但是封装了多个不同策略的实现
 * 经典案例
 * 购物车的满减运算
 **/


abstract class Strategy {

    abstract boolean support(String strategyName);

    abstract void doOperation();
}

class ConcreteStrategyA extends Strategy {

    @Override
    boolean support(String strategyName) {
        return "A".equalsIgnoreCase(strategyName);
    }

    @Override
    public void doOperation() {
        System.out.println("使用策略A来实现");
    }
}

class ConcreteStrategyB extends Strategy {
    @Override
    boolean support(String strategyName) {
        return "B".equalsIgnoreCase(strategyName);
    }

    @Override
    public void doOperation() {
        System.out.println("使用策略B来实现");
    }
}

class ConcreteStrategyC extends Strategy {
    @Override
    boolean support(String strategyName) {
        return "C".equalsIgnoreCase(strategyName);
    }

    @Override
    public void doOperation() {
        System.out.println("使用策略C来实现");
    }
}

class Context {
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        this.strategy.doOperation();
    }
}

public class StrategySimple {

    public static void main(String[] args) {

        Context contex;
        contex = new Context(new ConcreteStrategyA());
        contex.contextInterface();

//-----------------------
        String strategyName = "C";
        List<Strategy> strategyList = new ArrayList<>();
        strategyList.add(new ConcreteStrategyA());
        strategyList.add(new ConcreteStrategyB());
        strategyList.add(new ConcreteStrategyC());
        Strategy strategy = strategyList.stream().filter(c -> c.support(strategyName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("no Strategy resolver matches!"));
        strategy.doOperation();
    }

}