package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy implements InvocationHandler {

    private Object h;

    public JdkProxy(Hello h) {
        this.h = h;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");

        Object ret = method.invoke(h, args);

        System.out.println("after");
        return ret;
    }
}
