package cn.dlj1.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * stream for-loop 效率比较
 */
public class StreamForLoop {
    static int size = 10 * 10000;

    static List<Integer> list = new ArrayList<>(size);

    static {
        for (int i = 1; i <= size; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {

        long s = System.currentTimeMillis();
        System.out.println();
        List<Integer> l1 = list.stream().filter(ele -> {
            return ele % 4105 != 0;
        }).collect(Collectors.toList());

        System.out.println("stream:" + (System.currentTimeMillis() - s));
        s = System.currentTimeMillis();

        List<Integer> l2 = new ArrayList<>();
        for (int i = size; i > 0; i--) {
            if (list.get(i - 1) % 4105 != 0) {
                l2.add(list.get(i - 1));
            }

        }

        System.out.println("for-loop:" + (System.currentTimeMillis() - s));


    }

}
