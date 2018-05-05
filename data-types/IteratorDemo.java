import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    /**
     * 迭代器，每个集合都提供了按某种顺序迭代元素的方法，即都实现了 Iterator<E> 接口中的 iterator() 方法
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // 生成一个迭代器访问 list
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
            // remove 方法删除之前访问的元素，而不是删除迭代器当前指向的元素，所以中间没有调用 next 或 previous 方法时不能连续调用两次 remove 方法
            iter.remove();
        }

        // 实现了 Iterator<E> 接口的类实例，使用增强 for 循环时底层实现都会被转换成迭代器
        for (int n : list) {
            System.out.println(n);
        }
    }
}
