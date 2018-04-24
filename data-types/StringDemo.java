public class StringDemo {
    /**
     * String 不可变对象
     * StringBuilder 线程不安全
     * StringBuffer 线程安全
     */
    public static void main(String[] args) {
        // 在java虚拟机中，相同文字串只有一个实例，即下面的两个 hello 其实是同一个实例，所以使用 == 比较结构为 true
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2); // true

        // 但如果是两个不同的 String 对象，则不能使用 == 比较
        String str3 = new String("world");
        String str4 = "world";
        System.out.println(str3 == str4); // false
        // 使用 equals 方法才是比较字符串对象的值
        System.out.println(str3.equals(str4)); // true

        // 使用equals方法时，将确定的字符串放前面可防止空指针异常
        String str5 = "abc";
        // 这里如果 str5 在前面的话，如果 str5 为 null 则产生空指针异常
        System.out.println("abc".equals(str5));

        // 字符串是一个不可变对象，因此每次对字符串进行修改都是生成一个新的字符串对象
        String str6 = "Hello";
        str6 += " World"; // 这里新建了一个 String 对象，然后把 "Hello" + " World" 赋给新对象
    }
}
