package com.demo.study.test.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Vector;

/**
 * @description:
 * @author: Aaron Ma
 **/
public class Mytest {
    public static void main(String[] args) {

        String b = "abcabcabcadmin";
        b=b.replace("admin","");
        System.out.println(b);
        System.out.println(sumMonth());
    }

    public static Number sumMonth(){
        Integer[] months={1,2,3,4,5,6,7,8,9,10,11,12};
        int month=0;
        for (Integer integer : months) {
            month=month+integer;
        }

        ArrayList<Object> objects = new ArrayList<>();
        Vector<Object> objects1 = new Vector<>();

        return month;
    }
}
