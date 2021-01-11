package cgb.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 运行时可设置虚拟机参数为：
 * VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M(JDK6.0)
 * VM Args: -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M(JDK8.0)
 */
public class TestCglibProxy {
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(ProxyObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] os, MethodProxy proxy) throws Throwable {
                    System.out.println("I am proxy");
                    return proxy.invokeSuper(o, os);
                }
            });
            ProxyObject proxy = (ProxyObject) enhancer.create();
            proxy.greet();
        }
    }

    static class ProxyObject {
        public String greet() {
            return "Thanks for you";
        }
    }
}
