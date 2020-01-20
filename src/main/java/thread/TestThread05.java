package thread;

import java.rmi.AccessException;
import java.util.Arrays;

class Container{
	/**容器*/
	private Object[] array;
	/**有效元素个数*/
	private int size;
	public Container(){
		this(16);
	}
	public Container(int cap){
		array=new Object[cap];
	}
	/**
	 * 向容器size放数据
	 */
	public synchronized void add(Object data){
	 //1.判定容器是否已满，满了则扩容
	 if(size==array.length)
	 array=Arrays.copyOf(array, 2*array.length);
	 //2.放数据
	 array[size]=data;
	 //3.修改size的值
	 size++;
	}
	/**
	 * 从容器取数据，永远从第0个位置取数据
	 * @return
	 */
	public synchronized Object get(){
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
	public synchronized int size(){
		return size;
	}
}

public class TestThread05 {
	public static void main(String[] args) {
		Container c=new Container();
		c.get();
		for(int i=0;i<100;i++){
		  c.add(new byte[1024*1024*10]);
		  System.out.println(i);
		}
	}
}
