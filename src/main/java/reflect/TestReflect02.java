package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
class Container{
	private int cap;//容量
	private Container() {
		System.out.println("Container()");
	}
	private Container(int cap){
		System.out.println("Container(int cap)");
		this.cap=cap;
	}
	@Override
	public String toString() {
		return "Container [cap=" + cap + "]";
	}
	
}
public class TestReflect02 {
    static Object newInstance01(Class<?> cls)
    throws Exception{
    	//1.基于字节码对象(Class对象)获取构造方法对象
    	Constructor<?> con=
    	cls.getDeclaredConstructor();//无参构造
    	//2.基于构造方法发对象构建类的对象
    	//2.1设置构造方法可访问
    	con.setAccessible(true);
    	//2.2构建类的对象并返回
    	return con.newInstance();
    }
    static Object newInstance02(Class<?> cls)
    		throws Exception{
    	//1.基于字节码对象(Class对象)获取构造方法对象
    	Constructor<?> con=
    	cls.getDeclaredConstructor(int.class);//无参构造
    	//2.基于构造方法发对象构建类的对象
    	//2.1设置构造方法可访问
    	con.setAccessible(true);
    	//2.2构建类的对象并返回
    	return con.newInstance(10);
    }
    static void doUpdateField(Object target)
    throws Exception{
    	//1.获取类对象
    	Class<?> targetClass=target.getClass();
    	//2.获取类中的cap属性
    	//2.1获取属性
    	Field f1=
    	targetClass.getDeclaredField("cap");
    	//2.2设置属性可访问
    	f1.setAccessible(true);
    	//3.修改对象属性的值
    	f1.set(target, 20);
    }
	public static void main(String[] args)throws Exception {
		//1.加载类
		Class<?> c1=
		Class.forName("cgb.java.reflect.Container");
		//2.创建类的对象
		Container instance01=
		(Container)newInstance01(c1);
		Container instance02=
		(Container)newInstance02(c1);
		System.out.println(int.class==Integer.class);
		doUpdateField(instance02);
		System.out.println(instance02);
	}
}
