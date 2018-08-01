import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListDemo {
    /**
     * 数组列表
     * - ArrayList 是一个泛型类，不可以使用基本类型作为类型参数，需使用包装类如 Integer、Byte、Short、Long、Character、Float、Double、Boolean
     * - ArrayList 底层由一个 Object 数组实现，默认初始容量为 10，容量用完后以 1.5 倍速度进行动态扩容
     */
    public static void main(String[] args) {
        // new ArrayList时可不写类型，可由左边的类型推导得出
        ArrayList<Integer> al = new ArrayList<>();

        // 插入元素
        al.add(3);
        al.add(2);
        al.add(1);
        al.add(0);
        System.out.println(al); // [3, 2, 1, 0]

        // 删除元素
        al.remove(0); // [2, 1, 0]

        // 修改元素
        al.set(2, 1); // [2, 1, 1]

        // 获取元素
        System.out.println(al.get(0)); // 2

        // 排序数组列表
        Collections.sort(al); // [1, 1, 2]

        // 反转数组列表
        Collections.reverse(al); // [2, 1, 1]

        // 打乱数组列表
        Collections.shuffle(al);

        // 转成数组
        int[] array = al.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(array));
    }
}
