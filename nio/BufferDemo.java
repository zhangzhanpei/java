package nio;

import java.nio.IntBuffer;

public class BufferDemo {
    public static void main(String[] args) {
        // 分配一个5元素的buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);
        // 写入数据到buffer
        for (int i = 0; i < 3; i++) {
            intBuffer.put(i);
        }

        // 将buffer转入读取模式
        intBuffer.flip();

        // 读出buffer中的数据
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }

        // 清除已读数据
        intBuffer.compact();

        // 继续写入数据
        intBuffer.put(1);
        System.out.println("----------------------------------------------------");

        // 读出buffer中的数据
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
