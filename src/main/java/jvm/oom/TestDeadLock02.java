package jvm.oom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * jstack 用于生成java虚拟机当前时刻的线程快照
 * 执行 jstack -l 22345 ，检测到死锁问题
 */
class SyncTask02 implements Runnable {
    private List<Integer> from;
    private List<Integer> to;
    private Integer target;

    public SyncTask02(List<Integer> from, List<Integer> to, Integer target) {
        this.from = from;
        this.to = to;
        this.target = target;
    }

    @Override
    public void run() {
        moveListItem(from, to, target);
    }

    private static void moveListItem(List<Integer> from,
                                     List<Integer> to, Integer item) {
        log("attempting lock for list", from);
        synchronized (from) {
            log("lock acquired for list", from);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log("attempting lock for list ", to);
            synchronized (to) {
                log("lock acquired for list", to);
                if (from.remove(item)) {
                    to.add(item);
                }
                log("moved item to list ", to);
            }
        }
    }

    private static void log(String msg, Object target) {
        System.out.println(Thread.currentThread().getName() +
                ": " + msg + " " +
                System.identityHashCode(target));
    }
}

public class TestDeadLock02 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 3, 7, 9, 11));

        Thread thread1 = new Thread(new SyncTask02(list1, list2, 2));
        Thread thread2 = new Thread(new SyncTask02(list2, list1, 9));

        thread1.start();
        thread2.start();
    }
}
