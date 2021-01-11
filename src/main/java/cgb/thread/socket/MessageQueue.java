package cgb.thread.socket;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞式消息队列
 * 1.存储结构：数组
 * 2.算法：FIFO(先进先出)
 * @author qilei
 *
 */

public class MessageQueue {

	   private Message[] array;
	   /**记录有效元素个数*/
	   private int size;
	   public MessageQueue() {
		   array=new Message[16];
	   }
	   private ReentrantLock lock=new ReentrantLock();
	   private Condition producerCondition=lock.newCondition();
	   private Condition consumerCondition=lock.newCondition();
	   /**将消息永远存储在size位置*/
	   public void put(Message msg) {
		   lock.lock();
		   try {
		   //1.判定容器是否已满，满了则等待
		   while(size==array.length)try{producerCondition.await();}catch(Exception e) {}
		   //2.放消息
		   array[size]=msg;
		   //3.有效元素个数加1
		   size++;
		   //4.通知消费者取消息
		   consumerCondition.signalAll();
		   }finally {
			  lock.unlock(); 
		   }
	   }
	   /**永远从0位置取消息*/
	   public Message take() {
		   lock.lock();
		   try {
		   //1.判定容器是否为空，空则等待
			 while(size==0)try{consumerCondition.await();}catch(Exception e) {}
		   //2.取消息
			 Message msg=array[0];
		   //3.移动元素
			 System.arraycopy(array, 1, array, 0, size-1);
		   //4.有效元素个数减一
			 size--;
		   //5.size位置元素设置为null
			 array[size]=null;
		   //6.通知生产者继续放数据
			 producerCondition.signalAll();
		     return msg;
		   }finally {
			   lock.unlock();
		   }
	   }
}
