package cn.dlj1.simple;

public class Right {
    public static void main(String[] args) {

        String a = "hello world";

        System.out.println(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            c = (char) ((int)c << 10);
            sb.append(c);
        }

        a = sb.toString();
        System.out.println(a);

        sb.setLength(0);
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            c = (char) ((int)c >> 1);
            sb.append(c);
        }
        a = sb.toString();
        System.out.println(a);

    }
}
