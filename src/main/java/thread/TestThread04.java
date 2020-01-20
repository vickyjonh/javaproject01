package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟多个线程同时执行计数操作
 */
public class TestThread04 {

	static class Counter implements Runnable{
		private volatile int count;
		@Override
		public void run() {
			for(int i=0;i<10;i++){
			  doCount();
			}
		}
		public synchronized void doCount(){//this
			count++;//此操作非原子操作:三个步骤
		}
		public int getCount() {
			return count;
		}
	}
	public static void main(String[] args) {
		//1.构建计数任务对象
		Counter counter=new Counter();
		//2.构建多个线程
		List<Thread> list=new ArrayList<>();
		for(int i=1;i<=100;i++){
			list.add(new Thread(counter));
		}
		//3.启动线程
		for(Thread t:list){
			t.start();
		}
		//4.所有线程执行结束，输出counter的值。                
		//Thread.sleep(10000);
		//判定线程活着数量是否大于1
		
		while(Thread.activeCount()>1)
			Thread.yield();
		System.out.println(counter.getCount());
	}
}
