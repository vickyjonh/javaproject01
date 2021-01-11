package cgb.thread;

/**
 * 1、线程安全问题
 * 1)线程安全(多线程并发访问共同的的数据集仍旧能保证数据的正确性)
 * 2)线程不安全(多线程并发访问共同的数据集时数据出现了不正确的现象)
 * 2.导致线程不安全的原因
 * 1)多线程并发执行
 * 2)多线程存在共享数据集
 * 3)多线程在共享数据集上的操作是一个非原子操作
 */
public class TestThread01 {

    // 加volatile，一个线程修改了这个值，对其它线程立刻可见
    static volatile String content;

    public static void main(String[] args)
            throws Exception {
        //1.生产者向容器放数据
        Thread t = new Thread() {
            @Override
            public void run() {
                content = "hellworld";
            }
        };
        t.start();//main thread
        //2.消费者(Consumer)从容器取数据
//        while(content==null) {} //可能主线程不会马上释放CPU，这样写的话如果content变量没有volatile
                                // 修饰，可能会出现自旋的情况，一直死循环
        //while(content==null)Thread.yield();//释放cpu，同时处于就绪状态
//		t.join();//此时t线程优先执行，一直到执行结束。
        //while(content==null) {Thread.sleep(300);}//假如这段代码在锁里面，线程会释放锁
        System.out.println(content.toUpperCase());
    }
}



