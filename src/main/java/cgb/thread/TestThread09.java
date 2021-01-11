package cgb.thread;

import java.util.concurrent.CountDownLatch;

public class TestThread09 {
    //容器对象
    static volatile String content;
    public static void main(String[] args)throws Exception {
        // 该对象可以阻塞其它线程，由计数器判断是是否阻塞
        final CountDownLatch cdl=new CountDownLatch(1);//count=1 (计数器)
        //1.生产者向容器放数据
        Thread t=new Thread() {//producer
            @Override
            public void run() {
                content="helloworld";
                cdl.countDown();//此时count的值会减1
            }
        };
        t.start();//就绪状态(可运行状态)
        //2.消费者(Consumer)从容器取数据
        while(content==null)cdl.await();//此时会阻塞当前线程，当count变量的值为0时则释放解除阻塞
        System.out.println(content.toUpperCase());
    }
}
