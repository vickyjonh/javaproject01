package thread.mq;
public class TestProducerConsumer02 {
	static String content;
	public static void main(String[] args) {
		new Thread(){
			@Override
			public void run() {
				synchronized (TestProducerConsumer02.class) {
					content="helloworld";
					TestProducerConsumer02.class.notifyAll();
				}
			}
		}.start();
		synchronized (TestProducerConsumer02.class) {
			while(content==null)
			try{
			TestProducerConsumer02.class.wait();
			}catch(Exception e){e.printStackTrace();}
			System.out.println(content.toUpperCase());
		}
	}//请使用wait,notify方式解决13行可能出现的空指针问题
}