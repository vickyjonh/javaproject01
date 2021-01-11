package cgb.spi;

/**
 * java spi(全名为Service Provider Interface)提供了这样的一个机制：
 * 为某个接口寻找服务实现的机制。有点类似IOC的思想，就是将装配的控制权
 * 移到程序之外，在模块化设计中这个机制尤其重要。
 * 
 * 
 * java spi的具体约定为:当服务的提供者， 提供了服务接口的一种实现之后，
 * 在jar包的META-INF/services/目录里同时创建一个以服务接口命名的文件。
 * 该文件里就是实现该服务接口的具体实现类。而当外部程序装配这个模块的时候，
 * 就能通过该jar包META-INF/services/里的配置文件找到具体的实现类名，
 * 并装载实例化，完成模块的注入。 基于这样一个约定就能很好的找到服务接口
 * 的实现类，而不需要再代码里制定。
 * jdk提供服务实现查找的一个工具类：java.util.ServiceLoader
 * 
 * 
 * 应用场景分析
 * 
 *  1.common-logging    apache最早提供的日志的门面接口。
 *  只有接口，没有实现。具体方案由各提供商实现， 发现日志提供商是通过
 *  扫描 META-INF/services/org.apache.commons.logging.LogFactory配置文件，
 *  通过读取该文件的内容找到日志提工商实现类。只要我们的日志实现里包含了这个文件，
 *  并在文件里制定 LogFactory工厂接口的实现类即可。    
 *  2.jdbc    jdbc4.0以前， 开发人员还需要基于Class.forName("xxx")的方式来
 *  装载驱动，jdbc4也基于spi的机制来发现驱动提供商了，
 *  可以通过META-INF/services/java.sql.Driver文件里
 *  指定实现类的方式来暴露驱动提供者.
 * 
 */

import java.util.ServiceLoader;

public class TestSpi01 {//SPI 

	public static void main(String[] args) {
		//doLoadClass01();
		doLoadClass02();
	}

	private static void doLoadClass01() {
		ServiceLoader<IService> services=
		ServiceLoader.load(IService.class);
		for(IService s:services) {
			s.service();
		}
	}
	private static void doLoadClass02() {
		ServiceLoader<SearchService> services=
		ServiceLoader.load(SearchService.class);//META-INF/services/cgb.spi.SearchService
		for(SearchService s:services) {
			s.search("helloworld");
		}
	}
	
}
