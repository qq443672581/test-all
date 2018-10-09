package cn.dlj1.simple;

import java.io.*;

public class Cmd {

    public static void main(String[] args) throws IOException {

        File file = new File(Cmd.class.getResource("/").getFile());
        InputStream is = Runtime.getRuntime().exec("java.exe -version", new String[]{}, file).getErrorStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);

        String str = reader.readLine();

        System.out.println(str);

    }
}
