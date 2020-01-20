package thread;

public class TestSynchronized02 {
    private String LOCK="CHINA";
	public void doMethod01(){
		synchronized (this) {//this指向当前方法对应的实例对象
		
		}//同步代码块
	}
	public void doMethod02(){
		synchronized (LOCK) {
			
		}
	}
}
