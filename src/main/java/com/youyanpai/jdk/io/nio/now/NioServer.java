package com.youyanpai.jdk.io.nio.now;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * 服务端-未完成
 * @author wangxd
 */
public class NioServer {
	
	private int port;
	
	public void init() throws IOException{
		//获取Channel
		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.configureBlocking(false);
		channel.socket().bind(new InetSocketAddress(port));
		//获取Selector
		Selector selector = Selector.open();
		//Channel注册到Selector
		channel.register(selector, SelectionKey.OP_ACCEPT);
		System.out.println("NIO服务端启动完成");
	}
	
	public void listen(){
		
	}
	
	public NioServer(int port){
		this.port = port;
	}

}
