package cn.dlj1.threads;

public class A extends Thread{

    private int i = 0;

    @Override
    public void run() {

        System.out.println(String.format("%s:%d",Thread.currentThread().getName(),++i));
    }

}
