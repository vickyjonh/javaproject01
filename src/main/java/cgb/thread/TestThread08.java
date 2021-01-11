package cgb.thread;
/**
 * 线程之间的通讯
 * 1)进程内线程通讯
 * a)wait/nofity/notifyall
 * b)Condition
 * 2)进程间线程通讯
 *
 */
public class TestThread08 {
    //容器对象
    static volatile String content;
    public static void main(String[] args)throws Exception {
        //1.生产者向容器放数据
        Thread t=new Thread() {//producer
            @Override
            public void run() {
                synchronized (TestThread02.class) {
                    content="helloworld";
                    TestThread02.class.notifyAll();//通知具备当前锁的对象并且处于阻塞状态的线程可以开始工作了
                }
            }
        };
        t.start();//就绪状态(可运行状态)
        //2.消费者(Consumer)从容器取数据
        // 用类名作为锁
        synchronized (TestThread02.class) {
            //使用wait,是让当前线程处理阻塞状态并且这个方法在使用时要应用在同步代码块或同步方法，必须由同步锁来调用
            while(content==null)TestThread02.class.wait();//阻塞当前线程，同时释放锁
            System.out.println(content.toUpperCase());
        }

    }
}
