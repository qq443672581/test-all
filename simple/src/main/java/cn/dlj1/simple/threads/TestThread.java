package cn.dlj1.simple.threads;

public class TestThread extends Thread {

    private static Object lock = new Object();
    private static int i = 0;

    @Override
    public void run() {
        synchronized (lock){
            for (int j = 0; j < 10; j++) {
                i++;
            }
            System.out.println(String.format("[%d]",i));
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new TestThread().start();
        }
    }
}
