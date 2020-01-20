package spring.factory;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import spring.vo.BeanDefinition;

public class ClassPathXmlApplicationContext {
	/**通过此map存储bean的实例*/
	private Map<String,Object> instanceMap=new HashMap<>();
	/**通过map存储配置文件中定义的bean对象的配置信息*/
	private Map<String,BeanDefinition> beanMap=new HashMap<>();
	public ClassPathXmlApplicationContext(String file)throws Exception {
		//1.读取配置文件
		InputStream in=
				getClass().getClassLoader()
						.getResourceAsStream(file);
		//2.解析文件封装数据
		parse(in);
	}
	/**本次xml的解析基于dom实现
	 * 市场主流xml解析：dom,dom4j,sax,pull,...*/
	private void parse(InputStream in)throws Exception{
		//1.创建解析器对象(负责读取xml文件内容)
		DocumentBuilder builder=
				DocumentBuilderFactory.newInstance().newDocumentBuilder();
		//2.解析流对象
		Document doc=builder.parse(in);
		//3.处理document
		processDocument(doc);
	}
	private void processDocument(Document doc)throws Exception{
		//1.获取所有bean元素
		NodeList list=doc.getElementsByTagName("bean");
		//2.迭代bean元素,对其配置信息进行封装
		for(int i=0;i<list.getLength();i++){
			Node node=list.item(i);//bean
			//一个node对象对应一个BeanDefinition对象
			BeanDefinition bd=new BeanDefinition();//vo
			NamedNodeMap nMap=node.getAttributes();
			bd.setId(nMap.getNamedItem("id").getNodeValue());
			bd.setPkgClass(nMap.getNamedItem("class").getNodeValue());
			bd.setLazy(Boolean.valueOf(nMap.getNamedItem("lazy").getNodeValue()));
			//存储配置信息
			beanMap.put(bd.getId(),bd);
			//基于配置信息中lazy属性的值，判定此的的实例是否要延迟加载
			if(!bd.getLazy()){
				Class<?> cls=Class.forName(bd.getPkgClass());
				Object obj=newBeanInstance(cls);
				instanceMap.put(bd.getId(), obj);
			}
			//System.out.println(instanceMap);
		}
	}
	/**基于反射技术构建类的实例对象*/
	public Object newBeanInstance(Class<?> cls)throws Exception{
		//Class<?> cls=Class.forName(pkgClass);
		Constructor<?> con=cls.getDeclaredConstructor();
		con.setAccessible(true);
		return con.newInstance();
	}

	@SuppressWarnings("unchecked")
	public <T>T getBean(String key,Class<T> t)throws Exception{
		//1.判定当前instanceMap中是否有bean的实例
		Object obj=instanceMap.get(key);
		if(obj!=null)return (T)obj;
		//2.实例map中没有对象则创建对象，然后存储到map
		obj=newBeanInstance(t);
		instanceMap.put(key, obj);
		return (T)obj;
	}

	public static void main(String[] args)throws Exception {
		//1.初始化spring容器
		ClassPathXmlApplicationContext ctx=
				new ClassPathXmlApplicationContext("spring-configs.xml");
		//2.从spring容器获取bean实例
		//Object obj=ctx.getBean("obj",Object.class);
		Date date=ctx.getBean("date",Date.class);
		//System.out.println(obj);
		System.out.println(date);
	}

}
