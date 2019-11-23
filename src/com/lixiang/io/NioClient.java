package com.lixiang.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;

public class NioClient {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端已经启动。。。");
        //1、创建socket 通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        //2、设置异步非阻塞
        socketChannel.configureBlocking(false);//jdk1.7以上方可
        //指定缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(new Date().toString().getBytes());
        //切换到读取模式
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();
        socketChannel.close();
    }
}
