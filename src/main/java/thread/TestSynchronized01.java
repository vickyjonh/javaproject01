package thread;

public class TestSynchronized01 {

	//排它性：只能有一个线程进入方法内部执行
	static synchronized void doMethod01(){//锁TestSynchronized01.class
		System.out.println("doMethod01");
		//可重入性
		doMethod02();
	}

	static synchronized void doMethod02(){
		System.out.println("doMethod02");
	}
	
	public synchronized void doMethod03(){//this
		System.out.println(this);
		//默认使用的锁为this(当前访问这个方法对象)
	}
	
	
	public static void main(String[] args) {
		doMethod01();
		doMethod01();
		doMethod01();
	}
	
}
