package cgb.jvm.loader;

import java.io.*;

/**
 * 基于ClassLoader的自定义类加载器
 */
class MyClassLoader01 extends ClassLoader {
	private String baseDir;
	public MyClassLoader01(String baseDir) {
		this.baseDir=baseDir;
	}
	@Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassBytes(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }
	/**自己定义*/
    private byte[] loadClassBytes(String className) {
        String fileName =baseDir+className.replace('.', File.separatorChar) + ".class";
        System.out.println("fileName="+fileName);
        InputStream ins=null;
        try {
            ins= new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
        	if(ins!=null)try{ins.close();}catch(Exception e) {}
        }
    }
}

public class TestMyClassLoader01 {
	public static void main(String[] args) throws Exception{
		 String baseDir="E:\\WORKSPACE\\";
		 MyClassLoader01 classLoader = new MyClassLoader01(baseDir);
		 //此类不要和当前类放相同目录结构中
		 String pkgCls="pkg.Search";
	     Class<?> testClass = classLoader.loadClass(pkgCls);
	     Object object = testClass.newInstance();
	     System.out.println(object.getClass());
	     System.out.println(object.getClass().getClassLoader());
	}
}
