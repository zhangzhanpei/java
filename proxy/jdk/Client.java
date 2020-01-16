package proxy.jdk;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        /**
         * Jdk 动态代理通过生成代理类的 class 文件，然后通过该代理类调用实现类的方法
         * 只能代理接口方法
         */
        HelloInterface h = (HelloInterface) Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{HelloInterface.class}, new JdkProxy(new Hello()));
        h.sayHello();
    }
}
