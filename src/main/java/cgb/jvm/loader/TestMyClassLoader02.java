package cgb.jvm.loader;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 基于URLClassLoader的自定义类加载器
 */
class MyClassLoader02 extends URLClassLoader {
	public MyClassLoader02(URL[] urls) {
		super(urls,null);// 指定父加载器为 null
	}
}

public class TestMyClassLoader02 {
	public static void main(String[] args)throws Exception {
		File file=new File("E:\\WORKSPACE\\");
		//File to URI
        URI uri=file.toURI();
        URL[] urls={uri.toURL()};
        ClassLoader classLoader = new MyClassLoader02(urls);
        Class<?> cls = classLoader.loadClass("pkg.Search");
        System.out.println(cls.getClassLoader());
        Object obj = cls.newInstance();
        System.out.println(obj);
	}
}
