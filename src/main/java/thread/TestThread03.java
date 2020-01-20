package thread;
/**
 * 考察：线程问题
 * 案例：多线程执行售票任务
 */
public class TestThread03 {
    static class TicketTask implements Runnable{
    	int ticket=10;
    	@Override
    	public void run() {
    		doTicket();
    	}
    	private  void doTicket(){
    		while(true){
    			//多线程在此代码上排队执行(同步)
    			synchronized(this){//保证操作的原子性
    			 if(ticket<=0)break;
    			 String tName=Thread.currentThread().getName();
    			 System.out.println(tName+":"+ticket--);
    			 sleep();
    			}//排他锁(独占锁)
    		}
    	}
    	public void sleep(){
    		try{
    		Thread.sleep(100);
    		}catch(Exception e){}
    	}
    }
	public static void main(String[] args) {
		Runtime r=Runtime.getRuntime();
		System.out.println("Processors="+r.availableProcessors());
		//1.创建售票任务对象
		TicketTask task1=new TicketTask();
		TicketTask task2=new TicketTask();
		TicketTask task3=new TicketTask();
		TicketTask task4=new TicketTask();
		//2.创建多个线程模拟多个售票窗口
		Thread t1=new Thread(task1);
		Thread t2=new Thread(task2);
		Thread t3=new Thread(task3);
		Thread t4=new Thread(task4);
		//3.启动线程执行任务
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
