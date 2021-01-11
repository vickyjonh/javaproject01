package cgb.jvm.loader;

/**
 * @ClassName TestClassLoader03
 * @Description 获取类的加载器对象
 * @Author: guxiao
 * @Date: 2019/9/2 16:25
 */
public class TestClassLoader03 {
    public static void doMethod01() {
        ClassLoader loader=ClassLoader.getSystemClassLoader();
        System.out.println(loader);// AppClassLoader
        System.out.println(loader.getParent());// ExtClassLoader
        System.out.println(loader.getParent().getParent());// BootstrapClassLoader
    }
    public static void doMethod02() {
        ClassLoader loader =Thread.currentThread().getContextClassLoader();

        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }

    public static void doMethod03() {
        System.out.println("ClassLoader of this class:"+ TestClassLoader03.class.getClassLoader());
        System.out.println("ClassLoader of Object:" + Object.class.getClassLoader());
    }

    public static void main(String[] args) {
//        doMethod01();
//        doMethod02();
        doMethod03();
    }
}
