package cgb.callable;

import java.util.concurrent.*;

/**
 * @ClassName TestDemo
 * @Description
 * Callable是jdk1.5之后提供新的线程机制，比Runnable的变化：
 * ①call()的返回值类型可以自定义
 * ②call()的返回值可以接到
 * ③call()可以抛异常
 * ④Callable线程类只能通过线程池启动。不能通过 new Thread().start()启动
 * @Author: guxiao
 * @Date: 2019/9/24 18:12
 */
public class TestDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<String> future = service.submit(new C1());
        // 获取对应线程call()的返回值
        String result = future.get();
        System.out.println(result);
        service.shutdown();
    }
}

class C1 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("线程启动");
        return "success";
    }
}
