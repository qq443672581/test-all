package cn.dlj1.simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Google ");
        names.add("Runoob ");
        names.add("Taobao ");
        names.add("Baidu ");
        names.add("Sina ");

        System.out.println(names);
        Collections.sort(names, String::compareTo);
        System.out.println(names);

    }
}
