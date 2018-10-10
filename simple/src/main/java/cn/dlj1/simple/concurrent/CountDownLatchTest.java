package cn.dlj1.simple.concurrent;

/**
 * 同时开始
 * <p>
 * 并发包
 * <p>
 * 计数器
 * <p>
 * 貌似叫发令枪
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        java.util.concurrent.CountDownLatch count = new java.util.concurrent.CountDownLatch(2);

        new Thread() {
            @Override
            public void run() {
                System.out.println("线程1开始了");
                try {
                    Thread.sleep(2000);
                    count.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("线程2开始了");
                try {
                    Thread.sleep(2000);
                    count.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        System.out.println("任务都在开始了");
        try {
            count.await();
            System.out.println("任务都运行完成了!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
