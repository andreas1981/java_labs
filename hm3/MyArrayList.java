package com.kuzmenko.home_works.hm3;

/**
 * Created by Andrew_Elena on 12.06.2016.
 */
public class MyArrayList {
    private static final int DEFCOUNT = 10;
    private int size = 0;
    private Object arr[];

    public MyArrayList() {
        arr = new Object[DEFCOUNT];
    }

    public int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public boolean add(Object e) {
        if (arr.length == size) {
            Object buff[] = new Object[size + 10];
            for (int i = 0; i < arr.length; i++)
                buff[i] = arr[i];
            arr = buff;
            arr[size] = e;
            size++;
        } else {
            arr[size] = e;
            size++;
        }
        return true;
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        return remove(index);
    }

    public boolean remove(int index) {
        int j = 0;
        if (checkRange(index)) {
            Object buf[] = new Object[size - 1];
            for (int i = 0; i < size - 1; i++) {
                if (i != index) {
                    buf[j] = arr[i];
                    j++;
                }
            }
            arr = buf;
            size--;
            return true;
        } else
            return false;
    }

    public boolean remove(int fromIndex, int toIndex) {
        int j = 0;
        if (checkRange(fromIndex, toIndex)) {
            Object buf[] = new Object[size - (toIndex - fromIndex) - 1];
            for (int i = 0; i < size; i++) {
                if ((i < fromIndex) || (i > toIndex)) {
                    buf[j] = arr[i];
                    j++;
                }
            }
            arr = buf;
            size-=(toIndex - fromIndex) - 1;
            return true;
        } else
            return false;
    }

    void clear() {
        for (int i = 0; i < arr.length; i++)
            arr[i] = null;
        size = 0;
    }

    void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            System.out.print("");
        }


    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (arr[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(arr[i]))
                    return i;
        }
        return -1;
    }

    private boolean checkRange(int index) {
        if ((index > size) || (index < 0))
            return false;
        else
            return true;

    }

    private boolean checkRange(int fromIndex, int toIndex) {
        return (fromIndex < toIndex) && (checkRange(fromIndex)) && (checkRange(toIndex));
    }

}

class TestMyArrayList {
    public static void main(String[] args) {
        int index;
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(11);

        //arrayList.print();
        //arrayList.clear();
        //arrayList.print();

        //index = arrayList.indexOf(12);
        /*arrayList.remove(3);
        arrayList.remove(2);
        arrayList.remove(1);
        arrayList.remove(null);*/
        // arrayList.remove((Object) 1);
        //arrayList.remove(6);
        //arrayList.size();
        arrayList.print();
        System.out.println("\n");
        //arrayList.remove(1,3);
        //arrayList.remove(100);
        arrayList.remove(1, 3);
        arrayList.print();

        //System.out.println("MyArrayList is empty " + arrayList.isEmpty());
        //System.out.println("MyArrayList contains " + arrayList.contains(6));
    }
}
