package com.lixiang.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端已经被启动。。。。。。");
        //1、创建服务通道
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        //2、切换异步非阻塞
        socketChannel.configureBlocking(false);//jdk1.7以上
        //3、绑定连接
        socketChannel.bind(new InetSocketAddress(8080));
        //4、获取选择器
        Selector selector=Selector.open();
        //5、将通道注册到选择器中 并且指定其监听接受事件
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6、轮询获取“已经准备就绪的事件”
        while(selector.select()>0){
            //7、获取当前选择器中所有已经注册的选择键
            Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
            while(selectionKeys.hasNext()){
                //8、获取准备就绪事件
                SelectionKey selectionKey = selectionKeys.next();
                //9、判断准备就绪的事件类型
                if(selectionKey.isAcceptable()){
                    //10、如果是 接受就绪，则获取客户端连接
                    SocketChannel socketChannel1=socketChannel.accept();
                    //11、设置阻塞模式
                    socketChannel1.configureBlocking(false);
                    //12、注册通道
                    socketChannel1.register(selector,SelectionKey.OP_READ);
                } else if(selectionKey.isReadable()){
                    //13、获取当前选择器“就绪”状态的通道
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    //14、读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len=0;
                    while((len=channel.read(buffer))>0){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                selectionKeys.remove();
            }
        }
    }
}
