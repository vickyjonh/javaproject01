package jvm.oom;

public class TestCommand {

	public static void main(String[] args) {
		 byte[] b1;
		 while(true) {
			 b1=new byte[1024*1024];
		 }
	}
}
