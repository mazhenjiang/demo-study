package com.demo.study.test.common;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: Common模块的测试
 * @author: Aaron Ma
 **/

public class TestCommon {


    public static void main(String[] args) {

//        Instant now = Instant.now();
//        System.out.println(now);
//        List<String> strings = Arrays.asList("4", "2", "3", "5","1");
//        List<String> stringTest=null;
////        List<String> strinabc = Arrays.asList("c", "d", "e", "b","a");
////        List<String> collect = strinabc.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
////        for (String a:
////                collect) {
////            System.out.println(a);
////        }
////
//        stringTest.stream().forEach(c->{
//            System.out.println(c);
//        });


        int size=12;
        int length=0;
        if(size%10==0){
            System.out.println(size/10);
        }else{
            System.out.println(size/10 +1);
        }
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Map map = groupList(strings);


    }
    public static Map groupList(List list){

        int listSize=list.size();
        int toIndex=100;
        Map map = new HashMap();     //用map存起来新的分组后数据
        int keyToken = 0;
        for(int i = 0;i<list.size();i+=100){
            if(i+100>listSize){        //作用为toIndex最后没有100条数据则剩余几条newList中就装几条
                toIndex=listSize-i;
            }
            List newList = list.subList(i,i+toIndex);
            map.put("keyName"+keyToken, newList);
            keyToken++;
        }

        return map;
    }
}
