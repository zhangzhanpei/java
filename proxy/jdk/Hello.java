package proxy.jdk;

public class Hello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("Hello, Jdk Proxy");
    }
}
