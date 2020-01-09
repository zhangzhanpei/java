package nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class SelectorDemo {
    public static void main(String[] args) throws Exception {
        // 创建 selector
        Selector selector = Selector.open();
        // 创建 serverSocketChannel 并注册给 selector
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            // 从 selector 中获取发生事件的 channel
            while (selector.select(3000) == 0) {
                System.out.println("无事发生");
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            // 遍历有事件发生的 channel
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 如果是连接事件
                if (selectionKey.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("新连接进来了" + socketChannel.hashCode());
                }
                // 如果是可读事件
                if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    channel.read(buffer);
                    System.out.println(new String(buffer.array()));
                }
                // 处理事件后移除该 channel 防止重复处理
                iterator.remove();
            }
        }
    }
}
