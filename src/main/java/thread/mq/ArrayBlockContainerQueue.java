package thread.mq;
/**
 * wait()/notify()/notifyall()应用案例实现：
 * 手动实现阻塞式队列，并基于 wait()/notifyAll()方法实现实现线程在队列上的通
 * 讯
 * 有界消息队列：用于存取消息
 * 数据结构：数组结构(线性结构)
 * 算法：FIFO(先进先出)
 * 说明：
 * 线性结构：除了第一个节点和最后一个节点，其它每个
 * 节点都有一个直接前驱和一个直接后继
 *
 */
public class ArrayBlockContainerQueue {
	private Object[] array;
	/**记录有效元素个数*/
	private int size;
	public ArrayBlockContainerQueue(){
		this(16);
	}
	/**
	 * @param cap容器大小(最多能够存储多少数据)
	 */
	public ArrayBlockContainerQueue(int cap){
		array=new Object[cap];
	}
	/**
	 * 向容器放数据(保证过程的线程安全)
	 * 说明：数据要永远放在size位置
	 */
	public synchronized void put(Object data){
	   //1.判定容器是否已满，满了要等待
		while(size==array.length)
		try{this.wait();}catch(Exception e){}
	   //2.将数据放到size位置
		array[size]=data;
	   //3.有效元素个数加1(修改size的值)
		size++;
	   //4.通知处于阻塞状态的线程开始执行。
		this.notifyAll();
	}
	/**从容器取数据(保证过程的线程)
	 * 说明：数据永远从第0个位置开始取*/
	public synchronized Object take(){
		//1.容器是否为空，空则等待
		while(size==0)
		try{this.wait();}catch(Exception e){e.printStackTrace();}
		//2.取数据(0位置的值)
		Object data=array[0];
		//3.移动数据(0位置后面的数据要向前移)
		System.arraycopy(
				array, //src原数组
				1,//原数组位置
				array, //目标数组
				0,//目标数组位置
				size-1);//移动元素的个数(拷贝)
		//4.修改size的值
		size--;
		//5.设置size位置的值为null(恢复到初始状态)
		array[size]=null;//(有选择的实现)
		//5.通知处于阻塞状态的线程开始执行
		this.notifyAll();
		return data;
	}

}








