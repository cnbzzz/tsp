package cn.spacewalker.tsp.bg.receiver.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.Resource;
import java.net.InetSocketAddress;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/10 15:03
 * Copyright (c) 2017 www.space-walker.cn
 * <p>
 * Best wishes to bzzz
 */
public class Gbt32960Server {

    private Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private AutowireCapableBeanFactory capableBeanFactory;

    private static final int MAX_FRAME_LENGTH = 1024 * 1024 * 2;
    private static final int LENGTH_FIELD_OFFSET = 22;
    private static final int LENGTH_FIELD_LENGTH = 2;
    private static final int LENGTH_ADJUSTMENT = 0;
    private static final int INITIAL_BYTES_TO_STRIP = 0;

    private int port;

    public Gbt32960Server() {
        this.port = 9103;
    }

    public Gbt32960Server(int port) {
        this.port = port;
    }

    public void start(int port) {
        if (port < 1024) {
            port = this.port;
        }
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap sbs = new ServerBootstrap().group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new Gbt32960MsgDecoder(MAX_FRAME_LENGTH, LENGTH_FIELD_OFFSET, LENGTH_FIELD_LENGTH, LENGTH_ADJUSTMENT, INITIAL_BYTES_TO_STRIP, false));
                            Gbt32960ServerHandler handler = new Gbt32960ServerHandler();
                            capableBeanFactory.autowireBean(handler);
                            ch.pipeline().addLast(handler);
                        }
                    });

            sbs.option(ChannelOption.SO_BACKLOG, 2048 * 30);// serverSocketchannel的设置，链接缓冲池的大小
            sbs.option(ChannelOption.SO_RCVBUF, 1024 * 1024 * 2);// 接收缓冲池的大小
            sbs.option(ChannelOption.SO_SNDBUF, 1024 * 32);// 接收缓冲池的大小
            sbs.childOption(ChannelOption.SO_KEEPALIVE, true);// socketchannel的设置,维持链接的活跃，清除死链接
            sbs.childOption(ChannelOption.TCP_NODELAY, true);// socketchannel的设置,关闭延迟发送

            // 绑定端口，开始接收进来的连接
            ChannelFuture future = sbs.bind(port).sync();

            System.out.println("Server start listen at " + port);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }
    }

    public static void main(String[] args) throws Exception {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:spring/spring-socket.xml");
        context.refresh();
        Gbt32960Server server = (Gbt32960Server) context.getBean("gbt32960Server");
        server.start(9103);
    }
}
