package com.daiyuma.tmp.year2021.month01.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;


public class SimpleChatServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // 自定义处理类
        ch.pipeline().addLast(new NettyServerHandler());
    }
}
