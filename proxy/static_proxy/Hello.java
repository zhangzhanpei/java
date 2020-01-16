package proxy.static_proxy;

public class Hello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("Hello, Static Proxy");
    }
}
