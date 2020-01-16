package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        /**
         * Cglib 动态代理通过继承来实现代理
         * 无法代理 static、final 修饰的类，无法代理 private、static 修饰的方法
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new CglibProxy());
        Hello h = (Hello) enhancer.create();
        h.sayHello();
    }
}
