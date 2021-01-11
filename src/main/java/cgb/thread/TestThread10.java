package cgb.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread10 {
    //容器对象
    static volatile String content;
    //JUC包中提供的一种可重入锁
    static ReentrantLock lock=new ReentrantLock();//false,非公平锁
    // 生产者放完数据，通知消费者取，消费者阻塞
    static Condition consumerCondition=lock.newCondition();
    public static void main(String[] args)throws Exception {
        //1.生产者向容器放数据
        Thread t=new Thread() {//producer
            @Override
            public void run() {
                // 对共享数据集要加锁
                lock.lock();
                try {
                    content="helloworld";
                    consumerCondition.signalAll();//要唤醒的目标明确
                }finally {
                    lock.unlock();
                }
            }
        };
        t.start();//就绪状态(可运行状态)
        //2.消费者(Consumer)从容器取数据
        lock.lock();
        try {
            while(content==null)consumerCondition.await();//阻塞式方法
            System.out.println(content.toUpperCase());
        }finally {
            lock.unlock();
        }
    }
}
