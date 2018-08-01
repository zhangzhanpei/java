import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDemo {
    /**
     * 数组
     * - 构造数组时需确定长度，且长度不可再改变
     * - 可以构造长度为 0 的数组 new int[0]，但这并不等同与 null
     */
    public static void main(String[] args) {
        // 声明数组并赋值
        int[] arr1 = {1, 2, 3};

        // 创建10长度的数组，默认初始化数组元素值为0
        int[] arr2 = new int[10];
        Arrays.fill(arr2, 666); // 填充数组
        System.out.println("arr2 = " + Arrays.toString(arr2)); // [666, 666, 666, 666, 666, 666, 666, 666, 666, 666]

        // 二维数组
        int[][] arr3 = new int[10][10];
        arr3[5][5] = 666;
        System.out.println("arr2 = " + Arrays.deepToString(arr3)); // 使用 deepToString 输出多维数组

        // 复制数组
        System.out.println("arr1 = " + Arrays.toString(arr1)); // [1, 2, 3]
        int[] arr4 = arr1; // 这里 arr4 和 arr1 都指向同一个数组
        arr4[0] = 4; // 修改 arr4 会影响到 arr1
        System.out.println("arr1 = " + Arrays.toString(arr1)); // [4, 2, 3]
        int[] arr5 = Arrays.copyOf(arr1, arr1.length); // 使用 copyOf 方法得到一个全新的数组
        System.out.println("arr5 = " + Arrays.toString(arr5)); // [4, 2, 3]
        arr5[0] = 5; // [5, 2, 3]
        System.out.println("arr1 = " + Arrays.toString(arr1)); // 再次打印 arr1 = [4, 2, 3]

        // 转成AraryList，没啥好的办法
        ArrayList<Integer> al = new ArrayList<>();
        for (int i : arr5) {
            al.add(i);
        }
        System.out.println("al = " + al);

        // 数组排序
        Arrays.sort(arr5); // 普通排序
        Arrays.parallelSort(arr5); // 将排序分配到多个处理器中进行
        System.out.println("sorted arr5 = " + Arrays.toString(arr5));
    }
}
