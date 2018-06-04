import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Collection 的 stream() 方法返回一个流
 * 流是按需计算出来的，不像集合那样已经存在内存中
 * 流只能被遍历一次，如需再遍历一次需要重新从数据源获取流
 * 可以连接起来的流操作称为中间操作，关闭流的操作称为终端操作
 **/
public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 1, 7, 20, -3, 7);
        // 过滤，中间操作，满足 filter 条件的元素留下
        List<Integer> filter = list.stream().filter(n -> n > 0).collect(Collectors.toList()); // [5, 1, 7, 20, 7]
        // 去重，中间操作
        List<Integer> distinct = list.stream().distinct().collect(Collectors.toList()); // [5, 1, 7, 20, -3]
        // 限制，中间操作
        List<Integer> limit = list.stream().limit(3).collect(Collectors.toList()); // [5, 1, 7]
        // 跳过，中间操作
        List<Integer> skip = list.stream().skip(3).collect(Collectors.toList()); // [20, -3, 7]
        // 映射，中间操作，逐个元素进行处理如类型转换等
        List<String> map = list.stream().map(i -> String.format("\"%s\"", i)).collect(Collectors.toList()); // ["5", "1", "7", "20", "-3", "7"]
        // 查找，终端操作
        // Optional 是一个容器，isPresent() 方法判断容器中是否有值，ifPresent() 当容器有值时执行 lambda
        Optional<Integer> findFirst = list.stream().findFirst();
        findFirst.ifPresent(i -> System.out.println(i)); // 5
        // 匹配，终端操作
        boolean allMatch = list.stream().allMatch(i -> i > 0); // false
        boolean anyMatch = list.stream().anyMatch(i -> i < 0); // true
        boolean noneMatch = list.stream().noneMatch(i -> i < 0); // false
    }
}
