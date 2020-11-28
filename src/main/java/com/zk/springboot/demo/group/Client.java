package com.zk.springboot.demo.group;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client {

    private SocketChannel socketChannel;
    private Selector selector;
    private static final String IP = "127.0.0.1";
    private static final int PORT = 9090;
    private String username;


    public Client() {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(IP, PORT));

            socketChannel.configureBlocking(false);
            selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_READ);

            username = socketChannel.getRemoteAddress().toString().substring(1);

        } catch (Exception ex) {

        }
    }

    public void send(String msg) {
        try {
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            msg = username + "：" + msg;
            allocate.put(msg.getBytes());
            allocate.flip();
            socketChannel.write(allocate);
            allocate.clear();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void receive() {
        try {
            int select = selector.select();

            if (select > 0) {

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

                while (iterator.hasNext()) {

                    SelectionKey key = iterator.next();

                    if (key.isReadable()) {

                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer allocate = ByteBuffer.allocate(1024);
                        channel.read(allocate);
                        System.out.println(new String(allocate.array()).trim());

                    }
                    iterator.remove();
                }
            } else {
                // System.out.println("没有可用的通道");
            }
        } catch (IOException ex) {

        }
    }


    public static void main(String[] args) {
        Client client = new Client();

        new Thread(() -> {
            while (true) {
                client.receive();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            client.send(scanner.next());
        }
    }
}
