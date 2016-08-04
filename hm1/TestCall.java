package com.kuzmenko.home_works.hm1;

import Practice1.Task3.App;

import java.util.ArrayList;

/**
 * Created by Andrew_Elena on 02.06.2016.
 */
public class TestCall {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> arr = App.getCountFromFile("d:\\Java\\OracleAcademy\\J Programming\\Практика\\Практическое занятие 1\\baby2008.html");
        for (int i: arr)
            System.out.println(i);

        ArrayList<String> arr1 = App.getMenFromFile("d:\\Java\\OracleAcademy\\J Programming\\Практика\\Практическое занятие 1\\baby2008.html");
        for (String i: arr1)
            System.out.println(i);
    }
}
