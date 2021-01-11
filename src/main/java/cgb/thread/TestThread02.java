package cgb.thread;

/**
 * 线程之间的通讯
 * 1)进程内线程通讯
 * 2)wait/nofity/notifyall
 * b)Condition
 * 2)进程间线程通讯
 */
public class TestThread02 {

	static String content;
	public static void main(String[] args)throws Exception {
		Thread t=new Thread(){
			public void run() {//运行状态
				content="helloworld";
			};//run方法执行结束线程处于死亡状态
		};//新建状态
		t.start();//就绪状态(可运行状态)
		//Thread.sleep(1000);//主线阻塞
		while(content==null){
			Thread.yield();//让当前线程放弃CPU，处于就绪状态
		}
		System.out.println(content.toUpperCase());
	}
}
