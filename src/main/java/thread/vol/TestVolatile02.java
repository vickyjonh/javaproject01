package thread.vol;

/**
 * 安全发布代码示例
 */
class Singleton{
	private Singleton() {}
	private static Singleton  instance;
	public static Singleton getSingleton() {
		if(instance==null) {
			synchronized (Singleton.class) {
				instance=new Singleton();
			}
		}
		return instance;
	}
}
public class TestVolatile02 {
	public static void main(String[] args) {
		
	}
}
