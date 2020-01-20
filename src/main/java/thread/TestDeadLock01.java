package thread;

/**
 * 可能出现死锁的案例
 */
class SyncTask01 implements Runnable {
	private Object obj1;
	private Object obj2;
	public SyncTask01(Object o1, Object o2) {
		this.obj1 = o1;
		this.obj2 = o2;
	}
	@Override
	public void run() {
		synchronized (obj1) {
			work();
			synchronized (obj2) {
				work();
			}
		}
	}
	private void work() {
		try {Thread.sleep(30000);} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
public class TestDeadLock01 {

	 public static void main(String[] args) {
		 Object obj1 = new Object();
		 Object obj2 = new Object();
		 Thread t1 = new Thread(new SyncTask01(obj1, obj2), "t1");
		 Thread t2 = new Thread(new SyncTask01(obj2, obj1), "t2");
		 t1.start();
		 t2.start();
	}
}
