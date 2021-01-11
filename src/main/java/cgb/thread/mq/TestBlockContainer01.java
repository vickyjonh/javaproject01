package cgb.thread.mq;

import java.util.Arrays;

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
    /**用于向容器放数据:size位置*/
    public synchronized void put(T t) {
        //1.判定容器是否已满，满了则等待
        while(size==array.length)
            try{this.wait();}catch(Exception e) {e.printStackTrace();}
        //2.放数据(放size位置，最后一个有效元素的位置)
        array[size]=t;
        //3.有效元素个数加1
        size++;
        //4.通知消费者取数据
        this.notifyAll();
    }
    /**从容器中取数据：第0个位置*/
    @SuppressWarnings("unchecked")
    public synchronized T take() {
        //1.判定容器是否为空
        while(size==0)
            try{this.wait();}catch(Exception e) {e.printStackTrace();}
        //2.取第0个位置数据
        Object result=array[0];
        //3.移动数据
        System.arraycopy(array, 1, array, 0, size-1);
        //4.有效元素个数减一
        size--;
        //5.size位置元素设置为null
        array[size]=null;
        //5.通知生产者继续放数据
        this.notifyAll();
        return (T)result;
    }
    @Override
    public String toString() {
        return "BlockContainer [array=" + Arrays.toString(array) + "]";
    }

}
public class TestBlockContainer01 {
    public static void main(String[] args) {
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












