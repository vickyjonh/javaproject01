package cgb.thread.socket;

/**
 * 处理器
 */
public class Handler {

	 private Looper looper;
	 public Handler(Looper looper) {
		 this.looper=looper;
	 }
	 public void sendMsg(Message msg) {
		 msg.target=this;
		 this.looper.getMQ().put(msg);
	 }
	 public void handleMsg(Message msg) {
		 System.out.println(msg);
	 }
}
