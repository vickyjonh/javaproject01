package cgb.thread.socket;
/***
 * 消息通讯模型：
 * 1)主线程发消息给工作线程
 * 给哪个线程发消息，handler就要关联哪个looper
 * @author qilei
 */
public class TestMQ01 {
    static Looper workLooper;
	public static void main(String[] args) {
		//==========work thread=================
		Thread t=new Thread() {
			@Override
			public void run() {
				synchronized (TestMQ01.class) {
					workLooper=Looper.getLooper();
					TestMQ01.class.notifyAll();
				}
				workLooper.loop();
			}
		};
		t.start();
		//===========main thread=================
		synchronized (TestMQ01.class) {
			while(workLooper==null)try{TestMQ01.class.wait();}catch(Exception e) {}
		}
		Handler handler=new Handler(workLooper);
		Message msg=new Message();
		msg.what=1;
		msg.data="hello work thread";
		
		handler.sendMsg(msg);
		
		Message msg02=new Message();
		msg02.what=1;
		msg02.data="hello tedu";
		
		handler.sendMsg(msg02);
	}
}
