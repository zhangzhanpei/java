package oop;

/**
 * 接口使用 interface 关键字声明
 */
public interface InterfaceDemo {
    /**
     * 定义在接口中的任意变量自动为 public static final
     */
    int average = 0;

    /**
     * 接口方法默认为公有方法，无需声明为 public
     * 接口方法可以有默认实现，使用 default 关键字声明。实现类可重写默认实现，或保留默认实现
     */
    default boolean hasNext() {
        return true;
    }

    /**
     * 没有默认实现的方法称为抽象方法
     */
    int next();
}

/**
 * 实现接口。如果接口的方法未能全部实现，则需要把 class 声明为抽象类
 * 实现多个接口时，如果出现重名方法并且重名方法有默认实现时，需要手动解决冲突。如果重名方法都没有默认实现则不会产生冲突。
 */
class IntSequence implements InterfaceDemo {
    private int i;

    public int next() {
        i++;
        return i * i;
    }
}
