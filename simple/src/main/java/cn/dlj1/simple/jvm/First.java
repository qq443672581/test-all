package cn.dlj1.simple.jvm;

public class First {

    public static void main(String[] args) {
        String a = "aaaaa";
        System.out.println("你好");
        System.out.println(Runtime.getRuntime().maxMemory());
        System.gc();
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("再见");
    }

}
