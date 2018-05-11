package cn.spacewalker.tsp.bg.tbox.client;

import cn.spacewalker.tsp.bg.tbox.config.TboxConfig;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/10 17:16
 * Copyright (c) 2017 www.space-walker.cn
 */
@Component
public class TBoxClient {


    private Logger log = LogManager.getLogger(this.getClass().getName());

    @Resource
    private AutowireCapableBeanFactory capableBeanFactory;

    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "9103"));//9103,8080

    @Autowired
    private TboxConfig config;


    public void start() throws Exception {

        log.info("IP:{} Port:{}",
                config.getIp(),
                config.getPort());

        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new TBoxEncoder());
                            TBoxClientHandler handler = new TBoxClientHandler();
                            capableBeanFactory.autowireBean(handler);
                            ch.pipeline().addLast(handler);
                        }
                    });
            b.option(ChannelOption.SO_RCVBUF, 1024 * 32);// 接收缓冲池的大小
            b.option(ChannelOption.SO_SNDBUF, 1024 * 1024 * 2);// 发送缓冲池的大小
            b.option(ChannelOption.SO_KEEPALIVE, true);// socketchannel的设置,维持链接的活跃，清除死链接
            b.option(ChannelOption.TCP_NODELAY, true);// socketchannel的设置,关闭延迟发送

            ChannelFuture future = b.connect(HOST, PORT).sync();

            future.channel().closeFuture().sync();
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

}
