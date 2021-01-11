package cgb.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName TestDemo
 * @Description
 * 闭锁也叫线程递减锁。可以通过闭锁让线程挂起或继续执行。
 * 主要是通过CountDown()和await()来实现。
 * @Author: guxiao
 * @Date: 2019/9/21 16:28
 */
public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        new Thread(new BuyGuo(cdl)).start();
        new Thread(new BuyCai(cdl)).start();
        // 此方法会产生阻塞，阻塞放开的条件是闭锁初始数量=0
        cdl.await();
        System.out.println("开始做饭");
    }
}

class BuyGuo implements Runnable {
    private CountDownLatch cdl;
    public BuyGuo(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        System.out.println("锅买回来了");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 此方法每调用一次，闭锁的初始数量-1
        cdl.countDown();
    }
}

class BuyCai implements Runnable {
    private CountDownLatch cdl;
    public BuyCai(CountDownLatch cdl) {
        this.cdl = cdl;
    }
    @Override
    public void run() {
        System.out.println("菜买回来了");
        cdl.countDown();
    }
}
