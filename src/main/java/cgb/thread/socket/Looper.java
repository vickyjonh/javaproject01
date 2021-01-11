package cgb.thread.socket;
/**负责迭代消息队列，把消息发送给handler处理*/
public class Looper {
    private MessageQueue mQ;
    private static ThreadLocal<Looper> td=new ThreadLocal<>();
	private Looper() {
		mQ=new MessageQueue();
	}
	public MessageQueue getMQ() {
		return mQ;
	}
	public static Looper getLooper() {
		//从当前线程获取looper对象
	    Looper looper=td.get();
	    if(looper==null) {
	    	looper=new Looper();
	    	td.set(looper);
	    }
	    return looper;
	}
	public void loop() {
		while(true) {
			Message msg=mQ.take();
			//System.out.println(msg);
			//System.out.println(msg.target);
			msg.target.handleMsg(msg);
		}
	}
	public void remove() {
		td.remove();
	}
	
}
