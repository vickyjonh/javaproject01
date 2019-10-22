package threadpool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @ClassName TestDemo
 * @Description
 * @Author: guxiao
 * @Date: 2019/9/23 18:02
 */
public class TestDemo {
    @Test
    public void testCreate() {
        //--corePoolSize:核心线程数。
        //--当线程池初次创建时，是没有任何线程的。当有请求发起时，线程会创建核心线程
        //--在请求过程中，无论核心线程是否闲置，线程池都会创建核心线程，直到满足数量为止

        //--maximumPoolSize:最大线程数=核心线程数+临时线程数
        //--keepAliveTime：临时线程的存活时间
        //--unit：时间单位，一般用毫秒单位
        //--workQueue:等待队列，用于存放还未处理的请求
        ExecutorService service = new ThreadPoolExecutor(5,
                10,
                3000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("请稍后再尝试");
                    }
                });
        for(int i=0;i<21;i++){
            service.execute(new ClientRunner());
        }

        //--关闭线程池。此方法调用时，线程池不会接受外部请求了。
        //--但内部的线程并不会马上销毁，而是等到线程工作完之后再销毁
        //--使用线程池的好处可以避免线程的频繁创建和销毁，节省cpu性能。
        service.shutdown();
    }

    /*newCachedThreadPool:
     *①没有核心线程
     *②都是临时线程
     *③队列是同步队列
     *④最大线程数 Integer.MaxValue
     *总结：大池子小队列的好处：
     *可以很好的响应(及时)客户端请求。因为不需要等待排队。
     *但是注意：这种线程池适用短请求。如果都是长请求，可能会导致线程一直创建而不销毁，最后内存溢出
     */
    public void testCreate_1() {
        ExecutorService service = Executors.newCachedThreadPool();
    }

    /*newFixedThreadPool:
     *①都是核心线程，没有临时线程
     *②队列是无界队列(LinkedBlockingQueue)
     *总结：小池子大队列
     *这种线程池的作用：消峰限流。局限性是:不能及时响应客户端请求
     */
    public void testCreate_2() {
        ExecutorService service = Executors.newFixedThreadPool(10);
    }
}


class ClientRunner implements Runnable {

    @Override
    public void run() {
        System.out.println("处理客户端请求");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
