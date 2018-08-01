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
        //set.remove(3);

        // 遍历集合
        set.forEach(i -> System.out.println(i));

        Set<Integer> anotherSet = new HashSet<>();
        anotherSet.add(2);
        anotherSet.add(3);
        anotherSet.add(4);

        // 集合运算
        Set<Integer> resultSet = new HashSet<>();

        // 交集，set 和 anotherSet 共有的元素
        resultSet.addAll(set);
        resultSet.retainAll(anotherSet);
        System.out.println(resultSet); // [2, 3]

        // 差集，set 有而 anotherSet 没有的元素
        resultSet.clear();
        resultSet.addAll(set);
        resultSet.removeAll(anotherSet);
        System.out.println(resultSet); // [1]

        // 并集，两个集合的元素合并
        resultSet.clear();
        resultSet.addAll(set);
        resultSet.addAll(anotherSet);
        System.out.println(resultSet); // [1, 2, 3, 4]
    }
}
