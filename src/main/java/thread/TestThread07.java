package thread;

import java.util.concurrent.atomic.AtomicInteger;
//JUC
public class TestThread07 {

	static class Counter{
		//CAS (基于硬件技术--CPU)
		private AtomicInteger at=new AtomicInteger();
		public int doCount(){
			return at.incrementAndGet();
		}
	}
	public static void main(String[] args) {
		Counter c1=new Counter();
	    for(int i=0;i<100;i++){
		System.out.println(c1.doCount());
	    }
	}
}
