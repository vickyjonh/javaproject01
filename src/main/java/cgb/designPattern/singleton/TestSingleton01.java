package cgb.designPattern.singleton;
import java.util.ArrayList;
import java.util.List;
/**
 * 需求：设计一个类，保证此类的实例在一个JVM内部只有一份
 */
class Singleton01{//此设计在多线程环境中存在不安全
	private Singleton01(){}
	private static Singleton01 instance;
	public static Singleton01 getInstance(){
		if(instance==null){
			instance=new Singleton01();
		}
		return instance;
	}
}
class Singleton02{//此设计在多线程环境中存在不安全
	private Singleton02(){}
	private static Singleton02 instance;
	public static synchronized Singleton02 getInstance(){
		if(instance==null){
			instance=new Singleton02();
		}
		return instance;
	}
}
class Singleton03{//此设计在多线程环境中存在不安全
	private Singleton03(){}
	private static Singleton03 instance;
	//场景:大对象，稀少用,频繁访问会导致大量阻塞
	public static Singleton03 getInstance(){
		synchronized(Singleton03.class){
		 if(instance==null){
			instance=new Singleton03();
		 }//对象创建：按需加载，延迟加载
		}
		return instance;
	}
	public void display(){}
	public static void show(){}
}
class Singleton04{
	private Singleton04(){}
	/**volatile ：JMM(需要了解JMM)
	 * 
	 * 1)保证操作可见性(一个线程修改结束，其它线程可见)
	 * 2)禁止指令重排序
	 * 3)但是不能保证原子性，所以一般用于修饰变量
	 * 
	 * instance=new Singleton();
	 * a)堆内存开辟空间
	 * b)对象属性初始化
	 * c)执行构造方法
	 * d)为变量instance赋值
	 */
	private static volatile Singleton04 instance;
	/**
	 * 基于Singleton03进行优化
	 * 1)尽量减少阻塞的线程
	 * 2)尽量缩小锁的应用范围(锁的代码块)
	 */
	public static Singleton04 getInstance(){
		if(instance==null){//双重验证。
		  synchronized(Singleton04.class){
			if(instance==null){
				instance=new Singleton04();
			}
		  }
		}//大对象，稀少用
		return instance;
	}
}

class Singleton05{
	//private int[] array=new int[1024];
	/**
	 * 类加载时创建(实时加载)
	 */
	private static Singleton05 instance=
			new Singleton05();
	private Singleton05(){}
	//适合小对象，频繁访问
	public static Singleton05 getInstance() {
		return instance;
	}
	//Singleton05.show();
	public static void show(){}
}
class Singleton06{
	//private int[] array=new int[1024];
	/**
	 * 基于内部类实现对象的延迟加载策略
	 */
	static class Inner{
	   private static Singleton06 instance=
			new Singleton06();
	}
	private Singleton06(){}
	//适合大对象，频繁访问
	public static Singleton06 getInstance() {
		return Inner.instance;
	}
	//Singleton05.show();
	public static void show(){}
}
/**枚举类型：基于枚举创建单例对象*/
enum Singleton07{//Singleton07.class
	 instance;//此实例在类加载时创建
	 private Singleton07(){}
	 public void show(){}
}
//.......

public class TestSingleton01 {
	public static void main(String[] args) {
		//int[] t1=new int[Integer.MAX_VALUE];
		List<Thread> list=new ArrayList<>();
		for(int i=0;i<10;i++){
			list.add(new Thread(){
				@Override
				public void run() {
					System.out.println(Singleton07.instance);
				}
			});
		}
		for(Thread t:list){
			t.start();
		}
	}
}
