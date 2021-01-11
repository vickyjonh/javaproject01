package cgb.tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

/**
 * 基于tomcat依赖编写如下代码启动tomcat，进行debug分析
 */
public class TestTomcat01 {

	public static void main(String[] args)throws Exception {
		//1.构建tomcat对象
		Tomcat tomcat = new Tomcat();
		//2.构建connector对象，并指定协议
		//tomcat实用connector处理链接，一个tomcat可以配置多个connector
        Connector connector = new Connector("HTTP/1.1");
        //3.设置tomcat舰艇端口
		connector.setPort(8080);
		tomcat.setConnector(connector);
		//启动tomcat
		tomcat.start();
		tomcat.getServer().await();
	}
}
