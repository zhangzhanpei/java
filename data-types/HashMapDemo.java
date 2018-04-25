import java.util.HashMap;

public class HashMapDemo {
    /**
     * HashMap 由数组和链表实现，键值对加入时根据键计算数组下标，然后插入链表头部，O(1) 复杂度。查询时同样根据键找到数组下标，然后遍历链表进行查找。
     * JDK 1.8 后，当链表长度大于 8 时，将链表改为红黑树实现，将查询链表的 O(n) 降为 O(logN) 复杂度。
     * HashMap 并不是线程安全的，可使用 ConcurrentHashMap。
     * @param args
     */
    public static void main(String[] args) {
        // 创建一个 HashMap
        HashMap<String, Double> map = new HashMap<>();

        // 插入键值对
        map.put("语文", 130.0);
        map.put("数学", 100.0);
        map.put("物理", 138.0);

        // 获取键值对数量
        System.out.println(map.size());

        // 根据键获取值
        System.out.println(map.get("物理"));

        // 更新某个键的值
        map.put("物理", 90.0);

        // 删除键值对
        map.remove("物理");

        // 遍历一个 HashMap
        map.forEach((key, val) -> System.out.println(key + "成绩: " + val));
    }
}
