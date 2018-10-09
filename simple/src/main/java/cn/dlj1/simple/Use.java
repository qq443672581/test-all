package cn.dlj1.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Use {
    public static void main(String[] args) {

        List<Integer> names = Arrays.asList(3, 2, 7, 5);

        names.stream().map(integer -> integer * integer).distinct().forEach(integer -> {
            System.out.println(integer);
        });

    }

    public static class A {
    }
}
