package jvm.loader;

/**
 * 1）通过ClassLoader对象的loadClass方法加载类不会执行静态代码块。
 * 2）可通过指定运行参数，查看类的加载顺序。
 * -XX:+TraceClassLoading
 */
class ClassA {
    static {
        System.out.println("ClassA");
    }
}

public class TestClassLoader01 {
    public static void main(String[] args) throws Exception {
        ClassLoader loader= TestClassLoader01.class.getClassLoader();
//        loader.loadClass("jvm.loader.ClassA");
//        Class.forName("jvm.loader.ClassA");
        // 当initialize为false时，在加载类时不会执行静态代码块
        Class.forName("jvm.loader.ClassA", false, loader);
    }
}
