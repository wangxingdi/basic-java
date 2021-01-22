package com.daiyuma.tmp.year2021.month01.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.net.InetAddress;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    //收到数据时调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            ByteBuf in = (ByteBuf) msg;
            int readableBytes = in.readableBytes();
            byte[] bytes = new byte[readableBytes];
            in.readBytes(bytes);
            System.out.println("新消息："+new String(bytes));
            //System.out.print(in.toString(CharsetUtil.UTF_8));
            System.out.println("服务端接受的消息 : " + msg);
        } finally {
            // 抛弃收到的数据
            ReferenceCountUtil.release(msg);
        }
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }

    /*
     * 建立连接时，返回消息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //System.out.println("连接的客户端地址:" + ctx.channel().remoteAddress());
        System.out.println("连接的客户端地址:" + ctx.channel().remoteAddress());
        System.out.println("连接的客户端ID:" + ctx.channel().id());
        ctx.writeAndFlush("client" + InetAddress.getLocalHost().getHostName() + "success connected！ \n");
        System.out.println("connection");
        //StaticVar.ctxList.add(ctx);
        //StaticVar.chc = ctx;
        super.channelActive(ctx);
    }
}
