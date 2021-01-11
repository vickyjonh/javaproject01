package cgb.cglib;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
//使用cglib为此对象产生代理对象时，这个类不能使用final修饰
class LogService{
	public void delete(){
		System.out.println("delete");
	}
}
//CGLIB代理(代理对象会继承目标对象类型)
public class TestCglib01 {
	public static void main(String[] args) {
		//1.目标对象(没有实现接口)
		LogService target= new LogService();
		//2.为目标对象创建代理对象
		//2.1创建Enhancer对象，通过此对象为目标对象创建代理对象
		Enhancer en=new Enhancer();//相当于jdk中Proxy
		en.setCallback(new MethodInterceptor() {//相当于handler
			@Override
			public Object intercept(
					Object obj,//proxy
					Method method, //targetMethod
					Object[] args, 
					MethodProxy methodProxy) throws Throwable {
				//扩展业务:
				System.out.println("obj="+obj.getClass().getName());
				System.out.println("intercept");
				//目标业务:调用目标对象(父类对象)方法
				Object result=methodProxy.invokeSuper(obj, args);
				return result;
			}
		});
		//2.2设置代理对象的父类类型
		en.setSuperclass(target.getClass());
		//2.3创建代理对象
		LogService proxy=(LogService)en.create();
		System.out.println(proxy.getClass().getName());
		//2.3调用代理对象方法
		proxy.delete();
	}
}
