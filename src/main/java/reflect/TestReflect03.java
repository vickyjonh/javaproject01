package reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)//定义注解可以描述类
@interface Configuration{}

@Configuration
class DataSource{}

@Configuration
class AppConfig{
	//@Autowired
	private DataSource dataSouce;
}

public class TestReflect03 {
    static Object newInstance01(Class<?> targetClass)
    throws Exception{
    	//判定类上是否有对象注解
    	boolean flag=
    	targetClass.isAnnotationPresent(Configuration.class);
     	if(!flag)return null;
    	//1.基于字节码对象(Class对象)获取构造方法对象
    	Constructor<?> con=
    	targetClass.getDeclaredConstructor();//无参构造
    	//2.基于构造方法发对象构建类的对象
    	//2.1设置构造方法可访问
    	con.setAccessible(true);
    	//2.2构建类的对象并返回
    	return con.newInstance();
    }
	public static void main(String[] args)throws Exception {
		AppConfig cfg=(AppConfig)
		newInstance01(Class.forName("cgb.java.reflect.AppConfig"));
		System.out.println(cfg);
	}
	
}
