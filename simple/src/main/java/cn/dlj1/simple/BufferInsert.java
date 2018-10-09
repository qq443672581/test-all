package cn.dlj1.simple;

/**
 * substring stringbuilder 效率比较
 */
public class BufferInsert {

    public static void main(String[] args) {

        String str = "20180808";

        long j = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            a(new StringBuilder(str).insert(6, '-').insert(4, '-').toString());
        }
        System.out.println(System.currentTimeMillis() - j);
        j = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            a(str.substring(0, 4) + "-" + str.substring(4, 6) + "-" + str.substring(6, 8));
        }
        System.out.println(System.currentTimeMillis() - j);


    }

    public static void a(Object s) {

    }
}
