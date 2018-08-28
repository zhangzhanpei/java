package socket;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // 创建一个socket连接到127.0.0.1:6789
            Socket socket = new Socket("127.0.0.1", 6789);
            // 写缓冲
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                System.out.println("Client发送消息...");
                // 这里带上换行符防止服务端的readline方法一直阻塞
                bw.write("hello, world\n".toCharArray());
                // 将写缓冲中的内容发出去
                bw.flush();
                Thread.sleep(5000);
            }
            // socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
