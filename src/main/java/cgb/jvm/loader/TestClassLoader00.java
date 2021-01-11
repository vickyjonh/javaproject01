package cgb.jvm.loader;

/**
 * @ClassName TestClassLoader00
 * @Description
 * @Author: guxiao
 * @Date: 2019/9/2 10:17
 */
class Class01 {
    static int cap = 10;
    static {
        System.out.println("Class01.static");
    }
    static void doPrint() {
        System.out.println("print class info");
    }
}

class SubClass extends Class01 {
    static {
        System.out.println("SubClass");
    }
}

public class TestClassLoader00 {
    public static void main(String[] args) {
        // 1.访问类的静态变量
//        System.out.println(Class01.cap);
        // 2.访问类的方法
//        Class01.doPrint();
        // 3.创建类的实例
//        new Class01();
        // 4.创建子类实例
        new SubClass();
    }
}
