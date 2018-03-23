public static void main(String[] args) {
    //在java虚拟机中，每个文字串只有一个实例，即下面的两个hello其实是同一个实例，所以使用==比较为true
    String str1 = "hello";
    String str2 = "hello";
    System.out.println(str1 == str2); //true

    //但如果是两个不同的String对象，则不能使用==比较
    String str3 = new String("world");
    String str4 = "world";
    System.out.println(str3 == str4); //false
    System.out.println(str3.equals(str4)); //true, 使用equals方法才是比较字符串对象的值

    //使用equals方法时，将确定的字符串放前面可防止空指针异常
    String str5 = "abc";
    System.out.println("abc".equals(str5)); //这里如果str5在前面的话，如果str5为null则产生空指针异常
}
