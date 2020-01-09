package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {
    public static void main(String[] args) throws Exception {
        // new FileChannelDemo().wirteFile();
        new FileChannelDemo().readFile();
        // new FileChannelDemo().copyFile();
    }

    public void wirteFile() throws Exception {
        // 输出流到文件
        FileOutputStream fileOutputStream = new FileOutputStream("./nio-file.txt");
        // 获取输出流通道
        FileChannel fileChannel = fileOutputStream.getChannel();
        // 写入内容到 buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("666".getBytes());
        // 反转 buffer 转入读取模式
        byteBuffer.flip();
        // buffer 写入通道(即写入文件)
        fileChannel.write(byteBuffer);
        // 关闭
        fileChannel.close();
        fileOutputStream.close();
    }

    public void readFile() throws Exception {
        // 输入流
        FileInputStream fileInputStream = new FileInputStream("./nio-file.txt");
        // 获取输入流通道
        FileChannel fileChannel = fileInputStream.getChannel();
        // 写入内容到 buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        // 文件内容写入 buffer
        while (fileChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }
            byteBuffer.compact();
        }
        // 关闭
        fileChannel.close();
        fileInputStream.close();
    }

    public void copyFile() throws Exception {
        // 输入流
        File file = new File("./nio-file.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        // 获取输入流通道
        FileChannel inChannel = fileInputStream.getChannel();

        // 输出流
        FileOutputStream fileOutputStream = new FileOutputStream("./nio-file-copy.txt");
        // 输出流通道
        FileChannel outChannel = fileOutputStream.getChannel();

        // 输入通道的数据写到输出通道(即拷贝文件内容)
        outChannel.transferFrom(inChannel, 0, file.length());
        // 关闭
        inChannel.close();
        outChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
