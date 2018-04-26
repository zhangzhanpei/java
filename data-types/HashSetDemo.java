import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    /**
     * 集合中每个元素都是唯一的，有 HashSet、TreeSet
     */
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        // 添加元素到集合中
        set.add(1);
        set.add(2);
        set.add(3);

        // 集合元素个数
        System.out.println(set.size());

        // 判断是否在集合中
        System.out.println(set.contains(3));

        // 移除元素
        set.remove(3);

        // 遍历集合
        set.forEach(i -> System.out.println(i));

        //Iterator iter = set.iterator();
        //while (iter.hasNext()) {
        //    System.out.println(iter.next());
        //}
    }
}
