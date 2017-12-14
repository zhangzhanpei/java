import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DataType {
    public static void main(String[] args) {
        //byte类型，8位，-127 ~ 128
        byte b = 1;

        //short类型，16位，-32768 ~ 32767
        short s = 1;

        //int类型，32位，-2147483648 ~ 2147483647
        int i = 1;

        //long类型，64位，-9223372036854775808 ~ 9223372036854775807
        long l = 1;

        //float类型，32位
        float f = 0.5f;

        //double类型，64位，默认的小数就是 double 的，也可以是 0.5d
        double d = 0.5;

        //boolean类型，1位
        boolean bool = true;

        //char类型，16位
        char c = 'A';

        //String类型
        String str = "Hello World";

        //强制类型转换同PHP，如 byte 转成 int 类型
        int change = (int) b;

        //声明数组并赋值
        int[] arr1 = {1, 2, 3, 4};
        //创建10长度的数组，并默认初始化数组元素值为0
        int[] arr2 = new int[10];
        //二维数组
        int[][] arr3 = new int[10][10];

        //new ArrayList时可不写类型，由左边的类型推导得出
        ArrayList<String> al = new ArrayList<>();
        al.add("Hello");
        al.add("World");
        System.out.println(al.get(0)); //Hello
        al.set(1, "Tom"); //World -> Tom
        al.remove(1); //delete Tom
        String[] strArr = new String[al.size()];
        al.toArray(strArr); //ArrayList to Array
        System.out.println(Arrays.toString(strArr));

        //HashMap
        HashMap<String, Double> map = new HashMap<>();
        map.put("语文", 130.0); //插入键值对
        map.put("数学", 100.0);
        map.put("物理", 138.0);
        System.out.println(map.size()); //获取map键值对数量
        map.put("物理", 90.0); //更新某个键的值
        map.remove("物理"); //删除键值对
        System.out.println(map.get("物理")); //由键获取值
        map.forEach((key, val) -> System.out.println(key + "成绩:" + val)); //打印所有键值对
    }
}
