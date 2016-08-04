package com.kuzmenko.home_works.hm1;

/**
 * Created by Andrew_Elena on 26.05.2016.
 */
public abstract class Performance {
    abstract void test(int iterations);

    static void hotJVM(int iterations) {
        String str = "";
        for (int i = 0; i <= iterations; i++)
            str += "A";
    }
}

class StringPerformance extends Performance {

    void test(int iterations) {
        String str = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i <= iterations; i++)
            str += "A";
        long finish = System.currentTimeMillis();

        long diff = finish - start; // время работы
        System.out.println("Процедура тестирования " +
                " производительности операции (+) " + "для String " +
                " заняла " + diff +
                " миллисекунд" + " для " + iterations +
                " итераций");
        start = System.currentTimeMillis();
        for (int i = 0; i <= iterations; i++)
            str = str.concat("A");
        finish = System.currentTimeMillis();

        diff = finish - start; // время работы
        System.out.println("Процедура тестирования " +
                " производительности операции concat " + "для String " +
                " заняла " + diff +
                " миллисекунд" + " для " + iterations +
                " итераций");

    }
}

class StringBuildPerformance extends Performance {
    void test(int iterations) {
        String str = "";
        StringBuilder builder = new StringBuilder(str);
        long start = System.currentTimeMillis();
        for (int i = 0; i <= iterations; i++)
            builder.append("A");
        long finish = System.currentTimeMillis();

        long diff = finish - start; // время работы
        System.out.println("Процедура тестирования " +
                " производительности  для StringBuilder заняла " + diff +
                " миллисекунд" + " для " + iterations +
                " итераций");
    }
}

class StringBufferPerformance extends Performance {
    void test(int iterations) {
        String str = "";
        StringBuffer builder = new StringBuffer(str);
        long start = System.currentTimeMillis();
        for (int i = 0; i <= iterations; i++)
            builder.append("A");
        long finish = System.currentTimeMillis();

        long diff = finish - start; // время работы
        System.out.println("Процедура тестирования " +
                " производительности  для StringBuffer заняла " + diff +
                " миллисекунд" + " для " + iterations +
                " итераций");
    }
}

class TestPerformance {
    public static void main(String[] args) {
        Performance.hotJVM(10000);
        StringPerformance string = new StringPerformance();
        // разогрев JVM
        string.hotJVM(100000);
        string.test(100000);

        StringBuildPerformance builder = new StringBuildPerformance();
        builder.test(100000);

        StringBufferPerformance buffer = new StringBufferPerformance();
        buffer.test(100000);

    }
}

