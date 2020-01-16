package proxy.static_proxy;

/**
 * 静态代理
 * 缺点：如果 HelloInterface 新增接口方法，这个代理类就得多 Override 一个方法
 */
public class StaticProxy implements HelloInterface {

    private Hello h = new Hello();

    @Override
    public void sayHello() {
        System.out.println("before");
        h.sayHello();
        System.out.println("after");
    }
}
