package com.demo.study.test.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: Common模块的测试
 * @author: Aaron Ma
 **/

public class TestCommon {


    public static void main(String[] args) {

        List<String> strings = Arrays.asList("4", "2", "3", "5","1");
        List<String> strinabc = Arrays.asList("c", "d", "e", "b","a");
        List<String> collect = strinabc.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
        for (String a:
                collect) {
            System.out.println(a);
        }
    }
}
