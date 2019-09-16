package com.youyanpai.jdk.io.nio.now;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * 服务端
 * @author wangxd
 */
public class NioServer {
	
	private ServerSocketChannel channel;
	private int port;
	private Selector selector;
	ByteBuffer buffer = ByteBuffer.allocate(1024);
	
	public void init() throws IOException{
		channel = ServerSocketChannel.open();
		channel.configureBlocking(false);
		channel.socket().bind(new InetSocketAddress(port));
		selector = Selector.open();
		
		channel.register(selector, SelectionKey.OP_ACCEPT);
	}

	public NioServer() {
		super();
	}
	
	public NioServer(int port){
		this.port = port;
	}

}
