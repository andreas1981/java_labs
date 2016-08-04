package com.kuzmenko.home_works.hm3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrew_Elena on 09.06.2016.
 */

public class ListPerformance {
    public static void testAdd(List ob, int period) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < period; i++)
            ob.add(2, ob);
        long finish = System.currentTimeMillis();

        long diff = finish - start; // время работы
        System.out.println("Время добавления в " + ob.getClass() + " равно " + diff + " миллисекунд");
    }
    public static void testAddCollection(List ob, List addOb)
    {
        long start = System.currentTimeMillis();
            ob.addAll(2, addOb);
        long finish = System.currentTimeMillis();

        long diff = finish - start; // время работы
        System.out.println("Время добавления коллекции в " + ob.getClass() + " равно " + diff + " миллисекунд");
    }

    static void testDel(List ob, int count) {
        int i = count;
        long start = System.currentTimeMillis();
        while (i > 0) {
            System.out.println(ob);
            ob.remove(0);
            i--;
        }
        long finish = System.currentTimeMillis();

        long diff = finish - start; // время работы
        System.out.println("Время удаления в " + ob.getClass() + " равно " + diff + " миллисекунд");
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(Arrays.asList(1, 2, -4, 3, 5, 6));
        testAdd(arrayList, 100000);

        ArrayList addArrayList = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 7, 88, 77, 8, 9, 0, 2, 1, 4));
        testAddCollection(arrayList, addArrayList);

        LinkedList linkedList = new LinkedList(Arrays.asList(1, 2, -4, 3, 5, 6));
        testAdd(linkedList, 10000);

        ArrayList arrayList1 = new ArrayList();
        for (int i = 0; i < 20; i++)
            arrayList1.add(i);
        testDel(arrayList1, 20);

        LinkedList linkedList1 = new LinkedList();
        for (int i = 0; i < 20; i++)
            linkedList1.add(i);
        testDel(linkedList1, 20);

    }
}

