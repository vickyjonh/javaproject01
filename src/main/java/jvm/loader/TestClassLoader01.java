package jvm.loader;

/**
 * @ClassName TestClassLoader01
 * @Description
 * @Author: guxiao
 * @Date: 2019/9/2 10:08
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
