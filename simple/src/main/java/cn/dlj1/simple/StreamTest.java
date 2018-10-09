package cn.dlj1.simple;

import java.io.*;
import java.net.URL;

/**
 * 流测试
 */
public class StreamTest {

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {


        URL u2 = StreamTest.class.getResource("Test.class");

//        URL u = Test.class.getResource("/test");
        File file = new File(u2.getFile());
        InputStream is = new FileInputStream(file);

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());

        br.close();
        isr.close();
        is.close();

    }

    public static class A {


        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

}
