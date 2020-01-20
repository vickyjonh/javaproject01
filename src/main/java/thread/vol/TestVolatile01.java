package thread.vol;

/**
 * 状态标记代码示例
 */
class Looper{
	private volatile boolean isStop;
	public void loop() {
		for(;;) {
			if(isStop)break;
		}
	}
	public void stop() {
		isStop=true;
	}
}

public class TestVolatile01 {
    public static void main(String[] args)throws Exception {
    	final Looper looper=new Looper();
		Thread t1=new Thread() {
			public void run() {
				looper.loop();
			};
		};
		t1.start();
		t1.join(1000);
		looper.stop();
	}
}
