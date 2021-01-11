package cgb.jvm.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

/**
 * 热替换
 */
class MyClassLoader03 extends ClassLoader {
    private String basedir; // 需要该类加载器直接加载的类文件的基目录
    private HashSet<String> loadClasses; // 需要由该类加载器直接加载的类名

    public MyClassLoader03(String basedir, String[] classes)
            throws IOException {
        // 指定父类加载器为 null，打破双亲委派原则
        super(null);
        this.basedir = basedir;
        loadClasses = new HashSet<String>();
        customLoadClass(classes);
    }

    // 获取所有文件完整路径及类名，刷入缓存
    private void customLoadClass(String[] classes) throws IOException {
        for (String classStr : classes) {
            loadDirectly(classStr);
            loadClasses.add(classStr);
        }
    }

    // 拼接文件路径及文件名
    private void loadDirectly(String name) throws IOException {
        StringBuilder sb = new StringBuilder(basedir);
        String classname = name.replace('.', File.separatorChar) + ".class";
        sb.append(File.separator).append(classname);
        File classF = new File(sb.toString());
        instantiateClass(name, new FileInputStream(classF),
                classF.length());
    }

    // 读取并加载类
    private void instantiateClass(String name, InputStream fin, long len)
            throws IOException {
        byte[] raw = new byte[(int) len];
        fin.read(raw);
        fin.close();
        //将字节信息转换为了类对象并进行存储
        defineClass(name, raw, 0, raw.length);
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        Class<?> cls;
        // 判断是否已加载(在名字空间中寻找指定的类是否已存在)
        cls = findLoadedClass(name);
        if (!this.loadClasses.contains(name) && cls == null)
            cls = getSystemClassLoader().loadClass(name);
        if (cls == null) throw new ClassNotFoundException(name);
        if (resolve) resolveClass(cls);
        return cls;
    }
}

public class TestMyClassLoader03 {
    public static void main(String[] args) throws Exception {
        MyClassLoader03 loader = new MyClassLoader03("E:\\WORKSPACE\\",
                new String[]{"pkg.Search"});
        Class<?> cls = loader.loadClass("pkg.Search");
        System.out.println(cls.getClassLoader());
        Object search = cls.newInstance();
        System.out.println(search);
        Thread.sleep(20000);
        //再此执行加载时需要用新的类替换目标目录中的类
        loader = new MyClassLoader03("E:\\WORKSPACE\\",
                new String[]{"pkg.Search"});
        cls = loader.loadClass("pkg.Search");
        System.out.println(cls.getClassLoader());
        search = cls.newInstance();
        System.out.println(search);
    }
}
