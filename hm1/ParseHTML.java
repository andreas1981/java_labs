package com.kuzmenko.home_works.hm1;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew_Elena on 29.05.2016.
 */
class HTMLObj {
    private String id;
    private String male_name;
    private String female_name;


    HTMLObj(String id, String male_name, String female_name) {
        this.id = id;
        this.male_name = male_name;
        this.female_name = female_name;
    }

    public String getId() {
        return id;
    }

    public String getMale_name() {
        return male_name;
    }

    public String getFemale_name() {
        return female_name;
    }
}

public class ParseHTML {

    public static ArrayList<HTMLObj> readHTML(String path) throws IOException {   //"e:\\workspace\\src\\main\\java\\com\\kuzmenko\\home_works\\hm1\\baby2008.html"
        Pattern p = Pattern.compile("<.*>(\\d+)</.*><.*>([A-Z][a-z]*)</.*><.*>([A-Z][a-z]*)</.*>");
        Matcher m;
        FileReader file = new FileReader(path);
        BufferedReader br = new BufferedReader(file);
        String s;
        String id;
        String maleName;
        String femaleName;
        ArrayList<HTMLObj> arr = new ArrayList<>();
        while ((s = br.readLine()) != null) {
            id = "";
            maleName = "";
            femaleName = "";
            m = p.matcher(s);
            if (m.find())
                id = m.group(1);
            m = p.matcher(s);
            if (m.find())
                maleName = m.group(2);
            m = p.matcher(s);
            if (m.find())
                femaleName = m.group(3);
            if ((!id.equals("")) && (!maleName.equals("")) && (!femaleName.equals(""))) {
                //result = id + "," + maleName + "," + femaleName + "\n";
                //System.out.println(result);
                arr.add(new HTMLObj(id, maleName, femaleName));
            }
        }
        br.close();
        return arr;
    }

    static void writeToCSV(String path, HTMLObj[] objects) throws IOException {
        FileWriter writer = new FileWriter(path);
        String result = "";
        for (int i = 0; i < objects.length; i++) {
            result = objects[i].getId() + "," + objects[i].getMale_name() + "," + objects[i].getFemale_name() + "\n";
            writer.write(result);
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        ArrayList<HTMLObj> in = readHTML("e:\\workspace\\src\\main\\java\\com\\kuzmenko\\home_works\\hm1\\baby2008.html");
        HTMLObj[] out = new HTMLObj[in.size()];
        in.toArray(out);
        writeToCSV("e:\\workspace\\src\\main\\java\\com\\kuzmenko\\home_works\\hm1\\output.csv", out);
    }
}
