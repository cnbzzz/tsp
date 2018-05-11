package cn.spacewalker.tsp.bg.sender.client;

import cn.spacewalker.tsp.bg.pojo.rabbitmq.Gbt32960QueueConsumer;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This file is part of lightsaber Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/7/10 17:16
 * Copyright (c) 2017 www.space-walker.cn
 *
 */
public class Gbt32960ClientHandler extends ChannelHandlerAdapter {

    private Logger log = LogManager.getLogger(this.getClass().getName());

    public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception{
        log.error(var2.getMessage(), var2);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info(String.format("[%s] channelActive...", ctx.name()));
        Gbt32960QueueConsumer.getCtxMap().put(ctx.name(), ctx);
//        gbt32960ClientService.execute();
//        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
//        ctx.writeAndFlush(resp);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info(String.format("[%s] channelInactive...", ctx.name()));
        Gbt32960QueueConsumer.getCtxMap().remove(ctx.name());
        super.channelInactive(ctx);
    }
}
