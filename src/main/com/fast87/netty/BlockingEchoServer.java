package com.fast87.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

public class BlockingEchoServer {
	
	public static void main (String[] args) throws Exception {
        EventLoopGroup bossGroup = new OioEventLoopGroup(1);		 // OioEventLoopGroup로 변경블로킹 모드로 변경 
        EventLoopGroup workerGroup = new OioEventLoopGroup();		 // OioEventLoopGroup로 변경블로킹 모드로 변경 
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
             .channel(OioServerSocketChannel.class)					 // OioServerSocketChannel로 변경블로킹 모드로 변경 
             .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) {
                    ChannelPipeline p = ch.pipeline();
                    p.addLast(new EchoServerHandler());
                }
            });

            ChannelFuture f = b.bind(8888).sync();

            f.channel().closeFuture().sync();
        }
        finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
