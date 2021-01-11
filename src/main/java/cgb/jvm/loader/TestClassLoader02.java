package cgb.jvm.loader;

/**
 * @ClassName TestClassLoader02
 * @Description
 * @Author: guxiao
 * @Date: 2019/9/2 15:45
 */
class A{
    public static int a=10;
    static {
        System.out.println("A.a="+a);
    }
}

class B extends A {
    static {
        System.out.println("B");
    }
}

public class TestClassLoader02 {
    public static void main(String[] args) {
        System.out.println(B.a);
    }
}
