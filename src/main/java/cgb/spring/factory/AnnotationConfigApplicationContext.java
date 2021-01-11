package cgb.spring.factory;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import cgb.spring.annotation.ComponentScan;
import cgb.spring.annotation.Lazy;
import cgb.spring.annotation.Service;
import cgb.spring.config.SpringConfig;
import cgb.spring.service.SysLogService;
import cgb.spring.vo.BeanDefinition;

public class AnnotationConfigApplicationContext {
	private Map<String,Object> instanceMap=new HashMap<>();
	private Map<String,BeanDefinition> beanMap=new HashMap<>();
	public AnnotationConfigApplicationContext(Class<?> configCls)throws Exception {
		//1.读取配置类指定的包名
		ComponentScan cs=
				configCls.getDeclaredAnnotation(ComponentScan.class);
		String pkg=cs.value();
		//2.扫描指定包中的类
		String classPath=pkg.replace(".", "/");
		@SuppressWarnings("static-access")
		URL url=configCls.getClassLoader().getSystemResource(classPath);
		File fileDir=new File(url.getPath());
		File[] classFile=fileDir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isFile()&&file.getName().endsWith(".class");
			}
		});
		//3.封装文件信息
		processClassFiles(pkg,classFile);
	}
	private void processClassFiles(String pkg,File[] classFiles)throws Exception{
		for(File f:classFiles){
			String pkgClass=pkg+"."+f.getName().substring(0,f.getName().lastIndexOf("."));
			Class<?> targetCls=Class.forName(pkgClass);
			Service service=
					targetCls.getDeclaredAnnotation(Service.class);
			if(service==null)continue;
			BeanDefinition bd=new BeanDefinition();
			bd.setId(service.value());
			bd.setPkgClass(pkgClass);
			Lazy lazy=
					targetCls.getDeclaredAnnotation(Lazy.class);
			if(lazy!=null){
				bd.setLazy(lazy.value());
			}
			beanMap.put(bd.getId(),bd);
			if(!bd.getLazy()){
				Object obj=newBeanInstance(targetCls);
				//思考：为对象属性注入值(获取属性，获取属性上的@Autowire)
				instanceMap.put(bd.getId(), obj);
			}
		}
	}
	public Object newBeanInstance(Class<?> targetCls)throws Exception{
		Constructor<?> con=targetCls.getDeclaredConstructor();
		con.setAccessible(true);
		return con.newInstance();
	}
	@SuppressWarnings("unchecked")
	public <T>T getBean(String key,Class<T> cls)throws Exception{
		Object obj=instanceMap.get(key);
		if(obj!=null)return (T)obj;
		obj=newBeanInstance(cls);
		instanceMap.put(key, obj);
		return (T)obj;
	}
	public static void main(String[] args)throws Exception {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(SpringConfig.class);
		SysLogService logService=
				ctx.getBean("sysLogService",SysLogService.class);
		System.out.println("ls="+logService);
	}
}

