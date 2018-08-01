public class BasicTypeDemo {
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
    }
}
