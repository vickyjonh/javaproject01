package cgb.thread.socket;

/**
 * 消息通讯模型
 */
public class Message {
    /**表示要做什么*/
	int what;
	/**消息内容*/
	Object data;
	/**处理器对象*/
	Handler target;
	@Override
	public String toString() {
		return "Message [what=" + what + ", data=" + data + "]";
	}
	
	
}
