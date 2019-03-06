package cn.dlj1.threads;

public class B {

    public static void main(String[] args) {
        A a = new A();
        A b = new A();
        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.start();
        b.start();

    }

}
