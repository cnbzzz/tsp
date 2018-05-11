package cn.spacewalker.tsp.bg.receiver.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * This file is part of tsp Project
 * Created by bzzz (bzzz@space-walker.cn) on 2017/8/31 4:17
 * Copyright (c) 2017 www.space-walker.cn
 */
public class TimeClientHandler extends ChannelHandlerAdapter {

    //ChannelHandlerContext通道处理上下文
    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws InterruptedException { // (1)

        while (true) {
            ByteBuf time = ctx.alloc().buffer(4); //为ByteBuf分配四个字节
            time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
            ctx.writeAndFlush(time); // (3)
            Thread.sleep(2000);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
