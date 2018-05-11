package cn.spacewalker.tsp.bg.sender.client;

import cn.spacewalker.tsp.bg.pojo.rabbitmq.Gbt32960QueueConsumer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/10 17:16
 * Copyright (c) 2017 www.space-walker.cn
 *
 * Best wishes to little bzzz
 */
public class Gbt32960Client {

//    @Resource
//    private AutowireCapableBeanFactory capableBeanFactory;

    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "8080"));

    public void start() throws Exception {
        Gbt32960QueueConsumer queueConsumer = new Gbt32960QueueConsumer("queue");
        Thread thread = new Thread(queueConsumer);
        thread.start();

        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            Gbt32960ClientHandler clientHandler = new Gbt32960ClientHandler();
//                            capableBeanFactory.autowireBean(clientHandler);
                            ch.pipeline().addLast(clientHandler);
                        }
                    });

            ChannelFuture future = b.connect(HOST, PORT).sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

//    public static void main(String[] args) throws Exception {
//        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
//        context.load("classpath:spring/spring-service.xml");
//        context.refresh();
//        Gbt32960Client client = (Gbt32960Client)context.getBean("gbt32960Client");
//        client.start();
//
//        Gbt32960QueueConsumer queueConsumer = new Gbt32960QueueConsumer("queue");
//        Thread thread = new Thread(queueConsumer);
//        thread.start();
//    }
}
