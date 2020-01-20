package thread;

import java.util.Arrays;

/**
 * 设计一线程安全的计数器
 *
 * 设计一线程安全的容器（Container）。
 */
class Container02{
	/**容器*/
	private Object[] array;
	/**有效元素个数*/
	private int size;
	public Container02(){
		this(16);
	}
	public Container02(int cap){
		array=new Object[cap];
	}
	/**
	 * 向容器size放数据
	 */
	public void add(Object data){
	 synchronized (this) {
	 //1.判定容器是否已满，满了则扩容
	 if(size==array.length)
	  array=Arrays.copyOf(array, 2*array.length);
	 //2.放数据
	  array[size]=data;
	 //3.修改size的值
	  size++;
	 }
	}
	/**
	 * 从容器取数据，永远从第0个位置取数据
	 * @return
	 */
	public  Object get(){
	  synchronized (this) {
	  //1.判定容器是否为空,为空则抛出异常
	   if(size==0)throw new RuntimeException("容器为空");
	  //2.取数据
	   Object obj=array[0];
	  //3.移动数据
	   System.arraycopy(array,1,array,0,size-1);
	  //4.修改size值
	   size--;
	  //5.修改size位置的值
	   array[size]=null;//(可选)
	   return obj;
	  }
	}
	public synchronized int size(){
		return size;
	}
}

public class TestThread06 {
	public static void main(String[] args) {
	
	}
}
