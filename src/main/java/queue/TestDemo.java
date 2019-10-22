package queue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @ClassName TestDemo
 * @Description
 * 学习阻塞队列的使用。阻塞队列在高并发以及很多大数据框架底层有应用。
 * 队列的使用场景：将数据存入队列，可以启动缓冲作用。消峰限流。
 * 此外，队列另外的作用就是实现生产者和消费者之间的解耦。
 * @Author: guxiao
 * @Date: 2019/9/18 9:16
 */
public class TestDemo {
    /*
     * add方法当队列已满，会抛异常。使用这种方法来插入队列，可以通过捕获具体的异常来处理
     * offer方法当队列已满，会抛出false。未满则为true
     * put方法当队列已满，会产生阻塞。当队列有剩余容量，则阻塞放开。此方法常用
     * offer超时方法当队列已满，会产生阻塞。
     * 阻塞放开有两个：
     * ①队列有剩余容量。
     * ②过了指定的超时时间
     */
    @Test
    public void testPut() throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue<>(10);
        for(int i=0;i<10;i++) {
            queue.put(i);
        }
//        queue.add(11);
//        System.out.println(queue.offer(11));
//        queue.put(11);
        queue.offer(11,3, TimeUnit.SECONDS);
        System.out.println("hello");

    }

    /*
     * 1.remove方法对队列为空时，会抛异常 NoSuchElement
     * 如果队列不为空，则按FIFO的原则，取出相应的数据
     * 2.poll方法当队列为空，会抛null值。一般会根据poll返回值是否为null来判断队列是否已取完。
     * 3.take会产生阻塞(当队列为空)
     * 4.poll超时会产生阻塞，阻塞放开条件：①队列中有数据可取②过了指定的超时时间
     */
    @Test
    public void testGet() throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue<>(10);
//        queue.remove();
//        System.out.println(queue.poll());
//        queue.take();
        queue.poll(3,TimeUnit.SECONDS);
        System.out.println("hello");
    }

    /*
     * ArrayBlockingQueue:数组阻塞队列的特点：
     * ①有界队列，容量在创建时指定
     * ②是一个有界 的阻塞队列，其内部实现将对象放到数组里。所以查询快，增删慢。
     * LinkedBlockingQueue:链阻塞队列的特点：
     * ①是无界队列，默认的大小是Integer.MaxValue
     * ②底层是链数据结构，增删快。因为队列的使用一般是增或删，所以比Array常用
     *
     * 阻塞队列之所以能够保证并发安全，底层是通过锁机制来实现的（重入锁）
     */
    public void createQueue() {
        BlockingQueue q1 = new ArrayBlockingQueue<>(10);
        BlockingQueue q2 = new LinkedBlockingDeque<>();
    }

    /*
     * 优先级队列，要求插入队里的元素必须实现Comparable接口。
     * 队列会按CompareTo()中的比较规则，实现元素的排序。
     * 然后取出元素时，是按排序后的顺序来取的
     */
    @Test
    public void createCompareQueue() throws InterruptedException {
        BlockingQueue<Student> queue = new PriorityBlockingQueue<Student>();
        Student s1 = new Student("tom",100);
        Student s2 = new Student("jerry",150);
        Student s3 = new Student("tomy",80);
        queue.add(s1);
        queue.add(s2);
        queue.add(s3);
        for(int i=0;i<3;i++) {
            System.out.println(queue.take());
        }
    }



}
