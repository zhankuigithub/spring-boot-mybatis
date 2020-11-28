package com.zk.springboot.demo.group;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 利用nio实现的一个聊天室简易版
 */
public class Server {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final int PORT = 9090;


    public Server() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));

            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void listen() {
        try {
            while (true) {
                int select = selector.select();
                if (select > 0) {

                    Set<SelectionKey> selectionKeys = selector.selectedKeys();

                    Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

                    while (keyIterator.hasNext()) {

                        SelectionKey selectionKey = keyIterator.next();

                        if (selectionKey.isAcceptable()) {

                            // 获取一个socketChannel
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            // 注册
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            System.out.println("获取一个客户端连接:" + socketChannel.getRemoteAddress());
                        }

                        if (selectionKey.isReadable()) {

                            SocketChannel channel = (SocketChannel) selectionKey.channel(); // 获取当前连接上来的client
                            ByteBuffer allocate = ByteBuffer.allocate(1024);

                            try {
                                int read = channel.read(allocate);

                                if (read > 0) {
                                    String msg = new String(allocate.array());

                                    System.out.println(channel.getRemoteAddress() + "说:" + msg);

                                    // 获取所有注册到selector中的key  转发给其他客户端
                                    for (SelectionKey key : selector.keys()) {
                                        Channel targetChannel = key.channel();

                                        if (targetChannel instanceof SocketChannel && targetChannel != channel) { // 转发时排除自己
                                            SocketChannel dest = (SocketChannel) targetChannel;
                                            allocate.flip(); // 读写切换
                                            dest.write(allocate);

                                        }
                                    }

                                }
                            } catch (IOException ex) {
                                System.out.println("客户端:" + channel.getRemoteAddress() + "下线");
                                // 关闭通道
                                selectionKey.cancel();
                                channel.close();
                            }
                        }
                        // 移除
                        keyIterator.remove();
                    }
                } else {
                    // System.out.println("没有客户端连接");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
