package com.kuzmenko.home_works.hm3;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Andrew_Elena on 21.06.2016.
 */
public class MyLinkedList<E> {
    private Element element;
    int size = 0;
    private static class Element {
        Element previous;
        Element current;
        Element next;

        public Element(Element previous, Element current, Element next) {
            this.previous = previous;
            this.current = current;
            this.next = next;
        }
    }
    public boolean add(E Element)
    {
        return true;
    }
}



class TestMyLinkedList {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        System.out.println(list);
    }
}

