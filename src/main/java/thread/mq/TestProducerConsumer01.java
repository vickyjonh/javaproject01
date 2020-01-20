package thread.mq;


public class TestProducerConsumer01 {
    //生产者任务对象
	static class ProducerTask implements Runnable{
		private ArrayBlockContainerQueue container;
		public ProducerTask(ArrayBlockContainerQueue container) {
			this.container=container;
		}
		@Override
		public void run() {
			int i=1;
			while(true){
			  	this.container.put(i);
			  	i++;
			  	sleep();//每隔1秒放一次
			}
		}
	    public void sleep(){
	    	try{Thread.sleep(1000);}
	    	catch(Exception e){e.printStackTrace();}
	    }
	}
	static class ConsumerTask implements Runnable{
		private ArrayBlockContainerQueue container;
		public ConsumerTask(ArrayBlockContainerQueue container) {
			this.container=container;
		}
		@Override
		public void run() {
			while(true){
				Object obj=container.take();
				System.out.println(obj);
				sleep();
			}
		}
		public void sleep(){
	    	try{Thread.sleep(1000);}
	    	catch(Exception e){e.printStackTrace();}
	    }
	}
	public static void main(String[] args) {
		//1.构建一个容器对象
		ArrayBlockContainerQueue container=
		new ArrayBlockContainerQueue();
		//2.构建一生产者对象
		Thread producer1=new Thread(new ProducerTask(container));
		Thread producer2=new Thread(new ProducerTask(container));
		producer1.start();
		producer2.start();
		//3.创建一个消费者线程
		Thread consumer=
		new Thread(new ConsumerTask(container));
		consumer.start();
	}
}





