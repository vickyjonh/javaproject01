package cgb.jvm.oom;

/**
 * jps -l 输出应用程序主类完整 package 名称或 jar 完整名称.
 *
 * jps -v 列出 jvm 参数
 */
public class TestCommand {

	public static void main(String[] args) {
		 byte[] b1;
		 while(true) {
			 b1=new byte[1024*1024];
		 }
	}
}
