package cgb.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 悲观锁实现计数器1
 */
class Counter01{
	private volatile int count;
	//synchronized JDK 1.6之前性能非常差
	public synchronized void count(){
		count++;
	}//排它锁，独占锁，非公平锁
}
/**
 * 悲观锁实现计数器2
 */
class Counter02{
	private volatile int count;
	//公平锁,独占锁，排他锁
	private Lock lock=new ReentrantLock(true);
	public void count(){
		lock.lock();//加锁
		try{
		count++;
		}finally{
		lock.unlock();//解锁
		}
	}
}

/**
 * 乐观锁实现计数器
 */
class Counter03{
	//底层使用CAS算法(基于CPU硬件实现)
	private AtomicInteger at=new AtomicInteger();
	public void count(){
		at.incrementAndGet();
	}
}

class DateUtils{
	private static ThreadLocal<SimpleDateFormat>
	td=new ThreadLocal<>();
	public static String format(Date date){
		//从当前线程获取SimpleDataFormat对象
	    SimpleDateFormat sdf=td.get();
	    if(sdf!=null)
		return sdf.format(date);
	    System.out.println("创建SimpleDateFormat对象");
	    //当前线程没有则创建SiimpleDateFormat并且存储到当前线程
	    sdf=new SimpleDateFormat("yyyy/MM/dd");
	    td.set(sdf);//key为td(ThreadLocal)
	    return sdf.format(date);
	}
}
public class TestLock01 {
    public static void main(String[] args) {
		DateUtils.format(new Date());
		DateUtils.format(new Date());
		
		new Thread(){
			public void run() {
				DateUtils.format(new Date());
				DateUtils.format(new Date());
			}
		}.start();
	}
}
