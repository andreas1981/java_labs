package com.kuzmenko.home_works.hm4;

import java.io.File;

/**
 * Created by Andrew_Elena on 10.07.2016.
 */
public class FindPath {
    static void find(String path) {
        File[] list;
        File f = new File(path);
        list = f.listFiles();
        for (File value : list) {
            {
                System.out.println(value);
                if (value.isDirectory())
                    find(value.toString());
            }

        }
    }

    public static void main(String[] args) {
        String path = "d:\\Video";
        find(path);
    }
}
