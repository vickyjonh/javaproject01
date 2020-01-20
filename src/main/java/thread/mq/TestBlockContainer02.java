package cgb.thread.communication.eg02;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/***
 * 数据结构：线性结构
 * 数学算法：FIFO
 * @author qilei
 * @param <T>
 */
class BlockContainer<T>{
    /**存储有效元素*/
    private Object[] array;
    /**记录有效元素个数*/
    private int size;
    public BlockContainer() {
        this(16);
    }
    public BlockContainer(int cap) {
        array=new Object[cap];
    }
    //jdk1.5 提供的一种可重入锁
    private ReentrantLock lock=new ReentrantLock();
    //获取condition对象用于实现进程内线程的荣勋
    private Condition producerCondition=lock.newCondition();
    private Condition consumerCondition=lock.newCondition();
    /**用于向容器放数据:size位置*/
    public void put(T t) {
        lock.lock();
        try {
            //1.判定容器是否已满，满了则等待
            while(size==array.length)
                try{producerCondition.await();}catch(Exception e) {e.printStackTrace();}
            //2.放数据(放size位置，最后一个有效元素的位置)
            array[size]=t;
            //3.有效元素个数加1
            size++;
            //4.通知消费者取数据
            consumerCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    /**从容器中取数据：第0个位置*/
    @SuppressWarnings("unchecked")
    public  T take() {
        lock.lock();
        try {
            //1.判定容器是否为空
            while(size==0)
                try{consumerCondition.await();}catch(Exception e) {e.printStackTrace();}
            //2.取第0个位置数据
            Object result=array[0];
            //3.移动数据
            System.arraycopy(array, 1, array, 0, size-1);
            //4.有效元素个数减一
            size--;
            //5.size位置元素设置为null
            array[size]=null;
            //5.通知生产者继续放数据
            producerCondition.signalAll();
            return (T)result;
        }finally {
            lock.unlock();
        }
    }
    @Override
    public String toString() {
        return "BlockContainer [array=" + Arrays.toString(array) + "]";
    }
}
class Producer extends Thread{
    private BlockContainer<Object> container;
    public Producer(BlockContainer<Object> container) {
        this.container=container;
    }
    @Override
    public void run() {
        int i=1;
        while(true) {
            container.put(i);
            i++;
            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e) {}
        }
    }
}
class Consumer extends Thread{
    private BlockContainer<Object> container;
    public Consumer(BlockContainer<Object> container) {
        this.container=container;
    }
    @Override
    public void run() {
        while(true) {
            Object result=container.take();
            System.out.println(result);
            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e) {}
        }
    }
}
public class TestBlockContainer02 {
    public static void main(String[] args) {
        //doMethod01();
        doMethod02();
    }
    private static void doMethod02() {
        BlockContainer<Object> container=new BlockContainer<Object>();
        Producer pro=new Producer(container);
        Consumer con=new Consumer(container);
        pro.start();
        con.start();
    }
    private static void doMethod01() {
        BlockContainer<Integer> c1=new BlockContainer<>(3);
        c1.put(100);
        c1.put(200);
        c1.put(300);
        System.out.println(c1);
        //c1.put(400);
        c1.take();
        c1.take();
        c1.take();
        //c1.take();
        System.out.println(c1);
    }
}












