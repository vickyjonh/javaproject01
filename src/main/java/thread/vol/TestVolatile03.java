package thread.vol;

/**
 * 读写锁应用案例
 */
class Counter{
	private volatile int count;
	public int getCount() {//read
		return count;
	}
	public synchronized void doCount() {//write
		count++;
	}
}
public class TestVolatile03 {
	public static void main(String[] args) {
		
	}
}
