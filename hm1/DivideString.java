package com.kuzmenko.home_works.hm1;

/**
 * Created by Andrew_Elena on 26.05.2016.
 */
public class DivideString {
    public String[] dosplit(String value) throws Exception {
        if (value == null)
           throw new Exception("Строка не может быть NULL!");
        if (value.length() == 0)
           throw new Exception("Строка не должна быть пустой!");
        int start = 0;
        int finish = 0;
        int cnt_vowels = 0;
        int cnt_vowels1 = 0;
        String[] result;
        int j = 0;

        String vowels = "aeiouy";
        for (int i = 0; i < value.length(); i++)
            if (vowels.toLowerCase().contains(value.toLowerCase().substring(i, i + 1)))
                cnt_vowels++; //кол-во гласных
        result = new String[cnt_vowels];
        for (int i = 0; i < value.length(); i++)
            if (vowels.toLowerCase().contains(value.toLowerCase().substring(i, i + 1))) {
                cnt_vowels1++;
                finish = i;
                if (cnt_vowels != cnt_vowels1)
                //System.out.println(value.substring(start, finish+1));
                {
                    result[j] = value.substring(start, finish + 1);
                    j++;
                } else
                //System.out.println(value.substring(start, value.length()));
                {
                    result[j] = value.substring(start, value.length());
                    j++;
                }
                start = finish + 1;
            }
        return result;
    }

    void dosplit1(String value) {
        String vowels = "aeiouy";
        String[] splitted;
        char[] vowels1 = vowels.toCharArray();
        String res = value;
        String buf = "";
        for (int i = 0; i < vowels1.length; i++) {
            buf = Character.toString(vowels1[i]);
            res = res.toLowerCase().replace(buf, buf + "_");
        }
        for (int i = res.length(); i > 0; i--) {
            if ("_".contains(res.substring(i - 1, i))) {
                res = res.substring(0, i - 1) + (res.substring(i - 1, res.length())).replace(res.substring(i - 1, i), "");
                break;
            }
        }
        splitted = res.split("_");
        for (String t : splitted)
            System.out.println(t);
    }

    public static void main(String[] args) throws Exception {
        String[] arr;
        DivideString ob = new DivideString();
        arr = ob.dosplit("kabriolet");
        //ob.dosplit1("TEST");
    }

}
