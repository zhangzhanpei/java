package proxy.static_proxy;

public class Client {
    public static void main(String[] args) {
        StaticProxy proxy = new StaticProxy();
        proxy.sayHello();
    }
}
