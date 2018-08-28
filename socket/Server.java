package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // 创建一个服务端socket
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("Server端等待连接...");
            // 接受客户端连接生成连接socket
            Socket socket = serverSocket.accept();
            // 读缓冲
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;
            // 按行读取输入，readline是阻塞方法直到读到换行符
            while ((message = bufferedReader.readLine()) != null) {
                System.out.println(message);
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
