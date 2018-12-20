// 定义一个枚举类型
enum Size {
    SMALL, MEDIUM, LARGE
}

class Solution {
    public static void main(String[] args) {
        // 遍历枚举类型
        for (Size size : Size.values()) {
            System.out.println(size);
        }
        // 查看枚举元素的声明位置
        System.out.println(Size.LARGE.ordinal());
    }
}
